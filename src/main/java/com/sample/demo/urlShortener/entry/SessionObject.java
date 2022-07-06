package com.sample.demo.urlShortener.entry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SessionObject {
    private String SS_PMS_SEQ_NO;
    private String SS_PMS_CODE;
    private String SS_MEMBER_INFO;
    private String SS_LANG_TYPE;
    private String SS_REMOTE_IP;
    private String SS_SNS_NAVER_CLIENT_ID;
    private String SS_SNS_NAVER_CLIENT_SECRET;
    private String SS_SNS_NAVER_RETURN_HOST;
    private String SS_OPERATION_MODE;
    private String SS_PRIVACY_HOTEL;
    private String SS_CURRENCY_TYPE;
    private String SS_MEMBERSHIP_SEQ_NO;
    private String SS_MEMBERSHIP_TYPE;
    private String SS_MEMBERSHIP_POINT_TYPE;
    private String SS_MEMBERSHIP_COUP_CNT;
    private String SS_MEMBERSHIP_COUP_PRICE;
    private String SS_MEMBERSHIP_POINT_PRICE;
    private String SS_EXT_CHANNEL_SEQ_NO;
    private String SS_MEMB_SEQ_NO;
    private String SS_MEMB_MASTER_NO;
    private String SS_MEMB_LASTNAME;
    private String SS_MEMB_FIRSTNAME;
    private String SS_MEMB_EMAIL;
    private String SS_MEMB_TEL;
    private String SS_LOGIN_TYPE;
}
