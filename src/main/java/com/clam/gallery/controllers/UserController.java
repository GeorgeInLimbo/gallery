package com.clam.gallery.controllers;

import com.clam.gallery.models.Role;
import com.clam.gallery.models.User;
import com.clam.gallery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserbyID(@PathVariable("id") UUID userId) {
        return userService.getUser(userId);
    }

    @PostMapping()
    public User createUser(Map<String, String> body) {
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String email = body.get("email");
        Role role = Role.valueOf(body.get("role"));
        String password = body.get("password");

        User user = new User(firstName, lastName, email, role, password);

        return user;
    }

}
