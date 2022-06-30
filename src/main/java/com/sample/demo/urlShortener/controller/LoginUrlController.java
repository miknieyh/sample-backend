package com.sample.demo.urlShortener.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.demo.urlShortener.entry.Url;
import com.sample.demo.urlShortener.service.UrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginUrlController {

    @Autowired
    HttpSession session;

    @Autowired
    private UrlManager urlManager;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public String getUrl(@PathVariable String key, Model model) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Url url = urlManager.getUrlByKey(key);
        session.setAttribute("loginInfo",url.getLoginInfo());
        model.addAttribute("post",url);
        String loginInfo = objectMapper.writeValueAsString(url.getLoginInfo());
        model.addAttribute("loginInfo",loginInfo);
        return "urlChange";

    }
}
