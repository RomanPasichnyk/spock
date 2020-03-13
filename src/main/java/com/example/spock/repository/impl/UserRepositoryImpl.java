package com.example.spock.repository.impl;

import com.example.spock.model.User;
import com.example.spock.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findUserByName(String name) {
        List<User> users = initUsers();
        User expectedUser = null;
        for (User user : users) {
            if (user.getName().equals(name)) {
                expectedUser = user;
            }
        }
        return expectedUser;
    }

    private List<User> initUsers() {
        return Arrays.asList(
                new User("Roman", 15),
                new User("Andrii", 18),
                new User("Serhii", 21)
        );
    }

}
