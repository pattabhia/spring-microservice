package com.abhiram.springcloud.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/rest/hello/server/")
public class HelloResource {

    @GetMapping
    public String hello(){
        return "Hello World!";
    }
}
