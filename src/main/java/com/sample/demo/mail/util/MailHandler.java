package com.sample.demo.mail.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
public class MailHandler {

    private JavaMailSender mailSender;
    private MimeMessage message;
    private MimeMessageHelper messageHelper;

    public MailHandler(JavaMailSender javaMailSender) {
        try{
            this.mailSender = javaMailSender;
            message = javaMailSender.createMimeMessage();
            messageHelper = new MimeMessageHelper(message,true,"UTF-8");
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

    public void setFrom(String fromAddress) {
        try {
            messageHelper.setFrom(fromAddress);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void setTo(String toAddress){
        try {
            messageHelper.setTo(toAddress);
        }catch (Exception e){
             log.error(e.getMessage());
        }
    }

    public void setSubject(String subject){
        try {
            messageHelper.setSubject(subject);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void setText(String text,boolean useHtml) {
        try {
            messageHelper.setText(text, useHtml);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void setAttach(String displayFileName, String pathToAttachment){
        try {
            File file = new ClassPathResource(pathToAttachment).getFile();
            FileSystemResource fileSystemResource = new FileSystemResource(file);

            messageHelper.addAttachment(displayFileName,fileSystemResource);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void setInline(String contentId,String pathToInline){
        try {
            File file = new ClassPathResource(pathToInline).getFile();
            FileSystemResource fileSystemResource = new FileSystemResource(file);

            messageHelper.addInline(contentId,fileSystemResource);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void send(){
        try{
            mailSender.send(message);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
