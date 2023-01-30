package by.itacademy.hw11.service;

import by.itacademy.hw11.entity.User;
import by.itacademy.hw11.repository.UserRepository;
import by.itacademy.hw11.service.exception.UserNotExistException;
import by.itacademy.hw11.service.exception.WrongLoginException;
import by.itacademy.hw11.service.exception.WrongPasswordException;

import java.util.List;

public class UserService {
    private final List<User> users = UserRepository.getInstance().getUsers();

    public String authorization(String login, String password) {

        User user = findUser(login);

        try {
            if (user == null) {
                throw new UserNotExistException("Пользователя не существует");
            }
        } catch (UserNotExistException e) {
            return e.toString();
        }

        try {
            if (user.getPassword().equals(password)) {
                return "Вы авторизованы!";
            } else {
                throw new WrongPasswordException("Неверный пароль");
            }
        } catch (WrongPasswordException e) {
            return e.toString();
        }
    }

    public String registration(String login, String password) {
        boolean isLogin = login.matches("[\\w+]{5,20}");
        try {
            if (!isLogin) {
                throw new WrongLoginException("Неверный формат логина");
            }
        } catch (WrongLoginException e) {
            return e.toString();
        }

        try {
            if (password.matches("[\\w+]{8,}")) {
                users.add(new User(login, password));
                return "Вы зарегестрированы!";
            } else {
                throw new WrongPasswordException("Неверный формат пароля");
            }
        } catch (WrongPasswordException e) {
            return e.toString();
        }
    }


    private User findUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
