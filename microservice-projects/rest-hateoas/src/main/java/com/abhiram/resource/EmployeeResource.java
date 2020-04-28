package com.abhiram.resource;

import com.abhiram.model.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class EmployeeResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Example getAllEmployees(@PathVariable String id) {
        return restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employee/{id}", Example.class);
    }
}
