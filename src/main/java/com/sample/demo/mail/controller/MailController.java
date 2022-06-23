package com.sample.demo.mail.controller;

import com.sample.demo.mail.dto.MailDto;
import com.sample.demo.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/mail")
    public String mailSend(@RequestBody MailDto mailDto) {
        return mailService.mailSend(mailDto);
    }
}
