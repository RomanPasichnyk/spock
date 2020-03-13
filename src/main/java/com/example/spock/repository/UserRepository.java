package com.example.spock.repository;

import com.example.spock.model.User;

import java.util.List;

public interface UserRepository {
    User findUserByName(String name);

    List<User> findUserByAge(int rageA, int rageB);

}
