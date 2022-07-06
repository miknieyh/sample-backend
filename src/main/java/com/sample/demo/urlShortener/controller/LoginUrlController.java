package com.sample.demo.urlShortener.controller;

import com.sample.demo.urlShortener.entry.Url;
import com.sample.demo.urlShortener.service.UrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginUrlController {

    @Autowired
    HttpSession session;

    @Autowired
    private UrlManager urlManager;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public Url getUrl(@PathVariable String key)  {
        return urlManager.getUrlByKey(key);

    }
}
