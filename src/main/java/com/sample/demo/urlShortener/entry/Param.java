package com.sample.demo.urlShortener.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Param {
    private String url;
    private SessionObject loginInfo;
}
