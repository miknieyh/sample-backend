<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <script>
        const loginCookie = "A8BA1160F62AA1D3025E46453182D289";

        const xhr = new XMLHttpRequest();
        xhr.open('POST','http://localhost:8080/mail/autoLogin',true);
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=UTF-8');
        xhr.withCredentials=true;
        xhr.send(loginCookie);

    </script>
</head>
<body>

</body>
</html>

