<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <script>
        var sessionManger = function() {

            var sessionObj = {
                "SS_PMS_SEQ_NO": "",
                "SS_PMS_CODE": "",
                "SS_MEMBER_INFO": "",
                "SS_LANG_TYPE" : "",
                "SS_REMOTE_IP" : "",
                "SS_SNS_NAVER_CLIENT_ID" : "",
                "SS_SNS_NAVER_CLIENT_SECRET" : "",
                "SS_SNS_NAVER_RETURN_HOST" : "",
                "SS_OPERATION_MODE" : "",
                "SS_PRIVACY_HOTEL" : "",
                "SS_CURRENCY_TYPE" : "",
                "SS_MEMBERSHIP_SEQ_NO": "",
                "SS_MEMBERSHIP_TYPE": "",
                "SS_MEMBERSHIP_POINT_TYPE": "",
                "SS_MEMBERSHIP_COUP_CNT": "",
                "SS_MEMBERSHIP_COUP_PRICE": "",
                "SS_MEMBERSHIP_POINT_PRICE": "",
                "SS_EXT_CHANNEL_SEQ_NO": ""
            };

            var setSessionObj = function(sessionParam) {
                sessionObj["SS_PMS_SEQ_NO"] = sessionParam["SS_PMS_SEQ_NO"];
                sessionObj["SS_PMS_CODE"] = sessionParam["SS_PMS_CODE"];
                sessionObj["SS_MEMB_SEQ_NO"] = sessionParam["SS_MEMB_SEQ_NO"];
                sessionObj["SS_MEMB_MASTER_NO"] = sessionParam["SS_MEMB_MASTER_NO"];
                sessionObj["SS_MEMB_LASTNAME"] = sessionParam["SS_MEMB_LASTNAME"];
                sessionObj["SS_MEMB_FIRSTNAME"] = sessionParam["SS_MEMB_FIRSTNAME"];
                sessionObj["SS_MEMB_EMAIL"] = sessionParam["SS_MEMB_EMAIL"];
                sessionObj["SS_MEMB_TEL"] = sessionParam["SS_MEMB_TEL"];
                sessionObj["SS_LANG_TYPE"] = sessionParam["SS_LANG_TYPE"];
                sessionObj["SS_REMOTE_IP"] = sessionParam["SS_REMOTE_IP"];
                sessionObj["SS_LOGIN_TYPE"] = sessionParam["SS_LOGIN_TYPE"];
                sessionObj["SS_SNS_NAVER_CLIENT_ID"] = sessionParam["SS_SNS_NAVER_CLIENT_ID"];
                sessionObj["SS_SNS_NAVER_CLIENT_SECRET"] = sessionParam["SS_SNS_NAVER_CLIENT_SECRET"];
                sessionObj["SS_SNS_NAVER_RETURN_HOST"] = sessionParam["SS_SNS_NAVER_RETURN_HOST"];
                sessionObj["SS_OPERATION_MODE"] = sessionParam["SS_OPERATION_MODE"];
                sessionObj["SS_PRIVACY_HOTEL"] = sessionParam["SS_PRIVACY_HOTEL"];
                sessionObj["SS_CURRENCY_TYPE"] = sessionParam["SS_CURRENCY_TYPE"];
                sessionObj["SS_MEMBERSHIP_SEQ_NO"] = sessionParam["SS_MEMBERSHIP_SEQ_NO"];
                sessionObj["SS_MEMBERSHIP_TYPE"] = sessionParam["SS_MEMBERSHIP_TYPE"];
                sessionObj["SS_MEMBERSHIP_POINT_TYPE"] = sessionParam["SS_MEMBERSHIP_POINT_TYPE"];
                sessionObj["SS_MEMBERSHIP_COUP_CNT"] = sessionParam["SS_MEMBERSHIP_COUP_CNT"];
                sessionObj["SS_MEMBERSHIP_COUP_PRICE"] = sessionParam["SS_MEMBERSHIP_COUP_PRICE"];
                sessionObj["SS_MEMBERSHIP_POINT_PRICE"] = sessionParam["SS_MEMBERSHIP_POINT_PRICE"];
                sessionObj["SS_EXT_CHANNEL_SEQ_NO"] = sessionParam["SS_EXT_CHANNEL_SEQ_NO"];
            };

            var getSessionObj = function() {
                return sessionObj;
            };

            return {
                getSessionObj : getSessionObj,
                setSessionObj : setSessionObj
            }
        }();
        var loginInfo = ${loginInfo};
        function jsonKeyUpperCase(object){
            if(Array.isArray(object)){
                // 리스트<맵> 형식으로 넘어오는 경우 처리
                object.forEach((item, index) =>{
                    object[index] = Object.fromEntries(Object.entries(item).map(([key, value]) => [key.toUpperCase(), value]));
                });
                return object;
            }
            else {
                // 맵 형식으로 넘어오는 경우 처리
                return Object.fromEntries(Object.entries(object).map(([key, value]) => [key.toUpperCase(), value]));
            }
        }

        sessionManger.setSessionObj(jsonKeyUpperCase(loginInfo));
        <%--location.assign("${post.url}") ;--%>
    </script>
</head>
<body>

</body>
</html>

