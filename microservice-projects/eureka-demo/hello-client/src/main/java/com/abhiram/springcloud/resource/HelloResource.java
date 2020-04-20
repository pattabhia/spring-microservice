package com.abhiram.springcloud.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/rest/hello/client/")
public class HelloResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hello() throws URISyntaxException {
        URI url = new URI("http://hello-server/rest/hello/server/").normalize();
        return restTemplate.getForObject(url, String.class);
    }
}
