package com.example.spock.repository.impl;

import com.example.spock.model.User;
import com.example.spock.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = initUsers();

    @Override
    public User findUserByName(String name) {
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
                new User("Serhii", 21),
                new User("Maksym", 27),
                new User("Nazar", 31),
                new User("Anton", 35),
                new User("Anna", 12)
        );
    }

    @Override
    public List<User> findUserByAge(int rageA, int rageB) {
        List<User> approvedUsers = new ArrayList<>();
        try {
            for (User user : users) {
                if (user.getAge() > rageA && user.getAge() < rageB) {
                    approvedUsers.add(user);
                }
            }
        } catch (Exception e) {
            System.err.println("Bad request");
        }
        return approvedUsers;
    }
}
