package by.itacademy.hw11.repository;

import by.itacademy.hw11.entity.User;

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

    private void initUsers(){
        users.add(new User("Login_1","password_1"));
        users.add(new User("Login_2","password_2"));
    }

    public static UserRepository getInstance(){
        if (instance==null){
            return new UserRepository();
        }
        return instance;
    }
}
