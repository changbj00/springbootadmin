package com.feign.controller;

import org.springframework.stereotype.Component;

@Component
public class RemoteHystrix implements RemoteClient{
    @Override
    public String hello() {
        return "请求超时";
    }
}
