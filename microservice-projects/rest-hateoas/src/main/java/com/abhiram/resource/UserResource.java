package com.abhiram.resource;

import com.abhiram.model.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
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
        User user1 = new User("Ram", 2300L);
        User user2 = new User("Abhi", 2400L);
        return Arrays.asList(user1);
    }

    @GetMapping("/hateoas/all")
    public List<User> getHateOasUsers() {
        User user1 = new User("Ram", 2300L);
        Link link = ControllerLinkBuilder.linkTo(UserResource.class).slash(user1.getName()).withSelfRel();
        user1.add(link);
        User user2 = new User("Abhi", 2400L);
        user2.add(link);
        return Arrays.asList(user1);
    }
}
