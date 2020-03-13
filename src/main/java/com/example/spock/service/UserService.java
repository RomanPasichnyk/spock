package com.example.spock.service;

import com.example.spock.model.User;

public interface UserService {
    User findUserByName(String name);

    String doSomething(String name);
}
