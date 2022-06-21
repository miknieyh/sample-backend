#### application.yaml 세팅

```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: {GMAIL_ADDRESS}
    password: {GMAIL_PASSWORD}
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true

mailSend:
  userid: {FROM_ADDRESS}
```
2단계 인증을 사용하는 경우
password에는 앱 비밀번호를 생성하여 사용한다. 