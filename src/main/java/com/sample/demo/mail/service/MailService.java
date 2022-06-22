package com.sample.demo.mail.service;

import com.sample.demo.mail.dto.MailDto;
import com.sample.demo.mail.util.MailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    @Value("${mailSend.userid}")
    private String FROM_ADDRESS;

    public String mailSend(MailDto mailDto){
        MailHandler mailHandler = new MailHandler(mailSender);

        mailHandler.setFrom(FROM_ADDRESS);
        mailHandler.setTo(mailDto.getAddress());
        mailHandler.setSubject(mailDto.getTitle());
        String stringHtml = "<table width='720' height='auto' style='width:720px;padding:0 20px 0 20px;border:1px solid #eee'><tbody>" +
                "<tr width='720px' style='border:0;padding:0;margin:0 auto;text-align:center;width:100%'>" +
                "<td style='padding:60px 0 20px 0; margin:0;text-align:center;width:100%' >"+
                "<img src='https://ci4.googleusercontent.com/proxy/mRRSI3NAYNIgzmV29reBmCiFSGUp9HMMdLWzdDD-hc8LjdVLFGPvgo-s7BDjzFMaRl-wcDaqWviUyVi97I4REtiLdpWNbH2RGPFd1rGwDUBCV25eF0MtWCEmhQ=s0-d-e1-ft#https://be4.wingsbooking.com/resources/images/user/mail/mail-icon4-1.png'" +
                "style='display:inline-block' alt='icon' width='80' height='80' class='CToWud'></td></tr>" +
                "<tr width='720' style='border:0;padding:0;margin:0 auto;text-align:center'>" +
                "<td style='padding:0;margin:0;text-align:center;width:100%' >" +
                "<p style='font-size:27px;font-weight:600;color:#333333;margin:0;line-height:2em'>Reservation Confirmation</p>" +
                "<p style='font-size:16px;font-weight:400;color:#333333;margin:0;line-height:2em'>" +
                mailDto.getMessage() +
                "</p></td></tr></tbody></table>";
        mailHandler.setText(stringHtml,true);

        mailHandler.send();

        return "OK";
    }
}
