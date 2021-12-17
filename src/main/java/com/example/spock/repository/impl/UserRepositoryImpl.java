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
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return new User("Not found", 0);
    }

    private List<User> initUsers() {
        List<User> users = Arrays.asList(
                new User("Roman", 15),
                new User("Andrii", 18),
                new User("Serhii", 21)
        );
        return users;
    }

}
