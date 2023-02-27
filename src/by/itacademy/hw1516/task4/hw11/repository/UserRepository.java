package by.itacademy.hw1516.task4.hw11.repository;

import by.itacademy.hw1516.task4.hw11.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;
    private final List<User> users = new ArrayList<>();

    private UserRepository() {
        initUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            return new UserRepository();
        }
        return instance;
    }

    private void initUsers() {
        LocalDateTime registrationDate = LocalDateTime.now();
        users.add(new User("Login_1", "password_1", registrationDate));
        users.add(new User("Login_2", "password_2", registrationDate));
    }
}
