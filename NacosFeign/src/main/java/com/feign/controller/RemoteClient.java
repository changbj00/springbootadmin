package com.feign.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "privider",fallback = RemoteHystrix.class)
public interface RemoteClient {
    @GetMapping("/helloNacos")
    String hello();
}
