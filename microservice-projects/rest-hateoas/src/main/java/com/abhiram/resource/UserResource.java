package com.abhiram.resource;

import com.abhiram.model.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
        return Arrays.asList(user1, user2);
    }

    @GetMapping(value = "/hateoas/all", produces = MediaTypes.HAL_JSON_VALUE)
    public List<User> getHateOasUsers() {
        User user1 = new User("Ram", 2300L);
        //ControllerLinkBuilder is deprecated.
        Link link1 = WebMvcLinkBuilder.linkTo(UserResource.class).slash(user1.getName()).withSelfRel();
        Link link2 = WebMvcLinkBuilder.linkTo(UserResource.class).slash(user1.getSalary()).withRel("salary");
        user1.add(link1, link2);
        User user2 = new User("Abhi", 2400L);
        user2.add(WebMvcLinkBuilder.linkTo(UserResource.class).slash(user2.getName()).withSelfRel());
        return Arrays.asList(user1, user2);
    }
}