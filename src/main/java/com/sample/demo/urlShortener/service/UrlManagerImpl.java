package com.sample.demo.urlShortener.service;

import com.google.common.hash.Hashing;
import com.sample.demo.urlShortener.entry.Url;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UrlManagerImpl implements UrlManager {
    @Autowired
    private RedisTemplate<String, Url> redisTemplate;

    @Override
    public String getUrlByKey(@NotBlank String key) {

        Url url = redisTemplate.opsForValue().get(key);
        if (url == null) {
            throw new RuntimeException("There is no shorter URL for : " + key);
        }
        return url.getUrl();
    }

    @Override
    public Url shortenUrl(@NotBlank String url) {
        UrlValidator urlValidator = new UrlValidator(
                new String[]{"http", "https"}
        );
        if(!urlValidator.isValid(url)){
            throw new RuntimeException("URL Invalid: " + url);
        }
        // generating murmur3 based hash key as short URL
        String key = Hashing.murmur3_32().hashString(url, Charset.defaultCharset()).toString();

        Url shortUrlEntry = Url.builder().key(key).createdAt(LocalDateTime.now()).url(url).build();

        //레디스에 저장
        redisTemplate.opsForValue().set(key, shortUrlEntry, 36000L, TimeUnit.SECONDS);

        return shortUrlEntry;
    }
}