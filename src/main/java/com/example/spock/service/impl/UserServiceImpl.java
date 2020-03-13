package com.example.spock.service.impl;

import com.example.spock.model.User;
import com.example.spock.repository.UserRepository;
import com.example.spock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByName(String name) {
        User user = userRepository.findUserByName(name);
        user.setName(user.getName() + " change in service");
        return user;
    }

    @Override
    public String doSomething(String name) {
        return name.toUpperCase();
    }

}
