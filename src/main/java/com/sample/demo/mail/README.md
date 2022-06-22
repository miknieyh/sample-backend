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

>script함수는 수신되는 내용에서 실행되지 않게 처리되기 때문에 a tag로 구성해야한다.
특정 페이지 고객 정보 담아야한다면 get 방식 url 정보를 넣어야 한다.

---

#### 구현한 기능 
- Gmail SMTPServer를 이용한 메일 발송
- html로 이루어진 메일 발송 
- 버튼 누르면 특정 사이트로 창 띄우기
- 첨부파일, 이미지 메일 발송 