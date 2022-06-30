package com.sample.demo.urlShortener.controller;

import com.sample.demo.urlShortener.entry.Param;
import com.sample.demo.urlShortener.entry.SessionObject;
import com.sample.demo.urlShortener.entry.Url;
import com.sample.demo.urlShortener.service.UrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/urlShortener")
public class UrlController {

    @Autowired
    private UrlManager urlManager;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity shortenUrl(@RequestBody Param param) {
        String url = param.getUrl();
        SessionObject loginInfo = param.getLoginInfo();
        Url shortUrlEntry = urlManager.shortenUrl(url,loginInfo);
        return ResponseEntity.ok(shortUrlEntry);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUrl(@PathVariable String key) {
        Url url = urlManager.getUrlByKey(key);
        return ResponseEntity.ok(url.getUrl());
    }
}