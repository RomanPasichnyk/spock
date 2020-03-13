package com.example.spock.service.impl;

import com.example.spock.model.User;
import com.example.spock.repository.UserRepository;
import com.example.spock.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByName(String name) {
        User user = null;
        try {
            user = userRepository.findUserByName(name);
            user.setName(user.getName() + " change in service");
        } catch (NullPointerException e) {
            System.err.println("User not found");
        }
        return user;
    }

    @Override
    public String doSomething(String name) {
        return name.toUpperCase();
    }

    @Override
    public List<User> findUserByAge(int rageA, int rageB) {
        return userRepository.findUserByAge(rageA, rageB);
    }
}
