package com.abhiram.resource;

import com.abhiram.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    @GetMapping("/all")
    public List<User> getUsers() {
        return Arrays.asList(new User());
    }
}
