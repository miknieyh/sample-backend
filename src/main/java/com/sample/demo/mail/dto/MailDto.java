package com.sample.demo.mail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MailDto {
    private String address;
    private String title;
    private String message;
}
