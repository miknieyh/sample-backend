package com.sample.demo.urlShortener.controller;

import com.sample.demo.urlShortener.service.UrlManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequestMapping("/shortner62")
public class Shortner62Controller {

    @Autowired
    private UrlManager urlManager;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public String getUrl(@PathVariable String key)  {
        return urlManager.findOriginalUrl(key);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createKey(@RequestBody String originalUrl) throws NoSuchAlgorithmException {
        return urlManager.CreateShortUrl(originalUrl);
    }
}
