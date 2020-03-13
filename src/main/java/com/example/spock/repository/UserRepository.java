package com.example.spock.repository;

import com.example.spock.model.User;

public interface UserRepository {
    User findUserByName(String name);

}
