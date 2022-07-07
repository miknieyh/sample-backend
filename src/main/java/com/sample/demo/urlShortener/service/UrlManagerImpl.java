package com.sample.demo.urlShortener.service;

import com.google.common.hash.Hashing;
import com.sample.demo.urlShortener.entry.Url;
import com.sample.demo.urlShortener.util.Base62;
import com.sample.demo.urlShortener.util.ShortnerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UrlManagerImpl implements UrlManager {
    @Autowired
    private RedisTemplate<String, Url> redisTemplate;
    @Autowired
    private Base62 base62;
    @Autowired
    private ShortnerUtil shortnerUtil;

    @Override
    public Url getUrlByKey(@NotBlank String key) {

        Url url = redisTemplate.opsForValue().get(key);
        if (url == null) {
            throw new RuntimeException("There is no shorter URL for : " + key);
        }
        return url;
    }


    @Override
    public Url shortenUrl(@NotBlank String url) {
        // generating murmur3 based hash key as short URL
        String key = Hashing.murmur3_32().hashString(url, Charset.defaultCharset()).toString();

        Url shortUrlEntry = Url.builder().key(key).createdAt(LocalDateTime.now()).url(url).build();

        //레디스에 저장
        redisTemplate.opsForValue().set(key, shortUrlEntry, 36000L, TimeUnit.SECONDS);

        return shortUrlEntry;
    }
    /**
     * BASE62 이용한 shorten url
     * **/
    @Override
    public String findOriginalUrl(String key) {
        boolean isValidStr = base62.checkInvalidCharacter(key);

        if(!isValidStr){
            throw new RuntimeException("잘못된 인코딩 값 : "+key);
        }
        String originalHash = base62.decoding(key);
        if(originalHash.length()!= 10){
            throw new RuntimeException("원본 해시 길이가 아닙니다. :"+originalHash);
        }

        Url foundUrl = redisTemplate.opsForValue().get(originalHash);
        if (foundUrl == null) {
            throw new RuntimeException("There is no shorter URL for : " + key);
        }
        return foundUrl.getUrl();
    }

    @Override
    public String CreateShortUrl(String originalUrl) throws NoSuchAlgorithmException {
        String hashValue = shortnerUtil.encrypt(originalUrl);
        String value = hashValue.substring(0,10);
        Url url = new Url(value,originalUrl,LocalDateTime.now());

        try {
            redisTemplate.opsForValue().set(value,url,36000L,TimeUnit.SECONDS);
        }catch (Exception e){
            log.error("Hash Collision Occured");
            int start = 0 ;
            int end = 0 ;

            while (redisTemplate.opsForValue().get(value)!= null && end <= 32 ){
                start ++;
                end = start + 10;
                value = hashValue.substring(start,end);
            }
            redisTemplate.opsForValue().set(value,url,36000L,TimeUnit.SECONDS);
        }
        log.info("Truncated Hash Value is {}",value);
        BigInteger bigInteger = new BigInteger(value,16);
        String encoding = base62.encoding(bigInteger);
        log.info ("Encoded with base62 value is {}",encoding);
        return encoding;
    }




}