package by.itacademy.hw1516.task4.hw11.service;

import by.itacademy.hw1516.task4.hw11.entity.User;
import by.itacademy.hw1516.task4.hw11.repository.UserRepository;
import by.itacademy.hw1516.task4.hw11.service.exception.UserNotExistException;
import by.itacademy.hw1516.task4.hw11.service.exception.WrongLoginException;
import by.itacademy.hw1516.task4.hw11.service.exception.WrongPasswordException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final List<User> users = UserRepository.getInstance().getUsers();
    private final LocalDateTime dateTime = LocalDateTime.now();

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
                user.setLastAuthorizationDate(dateTime);
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
                users.add(new User(login, password, dateTime));
                return "Вы зарегестрированы!";
            } else {
                throw new WrongPasswordException("Неверный формат пароля");
            }
        } catch (WrongPasswordException e) {
            return e.toString();
        }
    }

    public String getUsersOfDateRegistration(String dateStartAsString, String dateEndAsString) {
        LocalDateTime dateStart;
        LocalDateTime dateEnd;
        try {
            dateStart = LocalDateTime.parse(dateStartAsString,
                    DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy"));
            dateEnd = LocalDateTime.parse(dateEndAsString,
                    DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy"));
        } catch (DateTimeParseException e) {
            return e.getMessage();
        }
        return users.stream().filter(u -> u.getRegistrationDate().isAfter(dateStart)
                & u.getRegistrationDate().isBefore(dateEnd)).map(u -> u.toString()).collect(Collectors.joining("\n"));
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
