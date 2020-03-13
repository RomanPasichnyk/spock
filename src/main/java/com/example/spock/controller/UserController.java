package com.example.spock.controller;

import com.example.spock.model.User;
import com.example.spock.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User findUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    public String doSomething(String test) {
        return userService.doSomething(test).toLowerCase();
    }

    @GetMapping("/getname")
    public String getUserName(@RequestParam String name) {
        return userService.findUserByName(name).getName();
    }
}
