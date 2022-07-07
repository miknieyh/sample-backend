package com.sample.demo.urlShortener.service;

import com.sample.demo.urlShortener.entry.SessionObject;
import com.sample.demo.urlShortener.entry.Url;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.security.NoSuchAlgorithmException;

@Validated
public interface UrlManager {
    public Url getUrlByKey(@NotBlank String key);
    public Url shortenUrl(@NotBlank String url);
    public String findOriginalUrl(String key);
    public String CreateShortUrl(String key) throws NoSuchAlgorithmException;
}