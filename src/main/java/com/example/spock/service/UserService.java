package com.example.spock.service;

import com.example.spock.model.User;

import java.util.List;

public interface UserService {
    User findUserByName(String name);

    String doSomething(String name);

    List<User> findUserByAge(int rageA, int rageB);
}
