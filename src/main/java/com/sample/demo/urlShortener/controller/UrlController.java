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
    public ResponseEntity shortenUrl(@RequestBody String url) {
        Url shortUrlEntry = urlManager.shortenUrl(url);
        return ResponseEntity.ok(shortUrlEntry);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    @ResponseBody
    public Url getUrl(@PathVariable String key) {
        return urlManager.getUrlByKey(key);
    }
}