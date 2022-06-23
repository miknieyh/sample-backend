## Shorten Url ?
긴 url 을 짧게 축약시켜서 필요한 페이지로 직접 연결하는 기술
긴 url 페이지로 연결되는 리디렉션을 사용해서 수행
> 목적 : 중개역할을 하는 shorten url을 구성하여
별도 로그인 없이 페이지로 이동되도록 개발

### Redis
- 영속성을 지원하는 인메모리 데이터 저장소
- 빠른 key 조회 자체 expire 기능
    - expire기능 : 특정 간격으로 사라지게 할 수 있다.
- 저장할 데이터 value가 적기 때문에 가볍게 사용하기 적합
##### build.gradle 세팅
```gradle
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
```
##### configuration
```java
@Configuration
public class RedisConfiguration {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RedisConnectionFactory connectionFactory;

    @Bean
    RedisTemplate<String, Url> redisTemplate() {
        final RedisTemplate<String, Url> redisTemplate = new RedisTemplate<>();
        Jackson2JsonRedisSerializer valueSerializer = new Jackson2JsonRedisSerializer(Url.class);
        valueSerializer.setObjectMapper(objectMapper);
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(valueSerializer);
        return redisTemplate;
    }
}
```

### 알고리즘
- 원본 url --> shorten url(hash id)
- 레디스 사용
```java
@Autowired
StringRedisTemplate redisTemplate;
```

#### 원본 URL을 받아서 postmapping
```java
@PostMapping
public String create(@RequestBody String url){
}
```
- url유효성 검사기 commons-validator 이용 해서 UrlValidator.isValue 체크
```java
UrlValidator urlvalidator = new UrlValidator(
	new String[]{"http","https"}
);
if(urlValidator.isValid(url){
}
```
http, https 가 포함된 url 인지 체크

- 구글에서 제공하는 guava 사용 --> 해싱이라는 클래스를 가져옴
```gradle
com.goole.guava
guava
```
MurmurHash를 사용해서 고유한 클래스를 생성할 수 있는 알고리즘
텍스트를 다른것으로 암호화하고 싶을 때 사용
```java
String id = 
	Hashing.murmur3_32().hashString(url,_StandardCharsets.UTF_8);
    
redisTemplate.opsForValue().set(id,url);

return id;


```
- 예외처리
```java
throw new RuntimeException("URL Invalid : " + url);
```

#### id 값을 받아서 GetMapping
```java
@GetMapping(/{id})
public String getUrl(@PathVariable String id){
}
```
- 레디스에서 id로 해당 값을 조회
```java
String url = redisTemplate.opsForValue().get(id);
if(url == null) {
throw new RuntimeException("There is no shorten URL for : "+id);
}
return url;
```

