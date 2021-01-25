package com.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    RemoteClient remoteClient;

    @GetMapping("/feign")
    public String feigntest(){
        return remoteClient.hello();
    }
}
