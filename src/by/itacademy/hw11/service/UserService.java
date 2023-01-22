package by.itacademy.hw11.service;

import by.itacademy.hw11.entity.User;
import by.itacademy.hw11.repository.UserRepository;
import java.util.List;

public class UserService {
    private final List<User> users = UserRepository.getInstance().getUsers();
}
