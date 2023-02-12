package by.itacademy.hw12.task5.hw11.service;

import by.itacademy.hw12.task5.hw11.entity.User;
import by.itacademy.hw12.task5.hw11.repository.UserRepository;
import by.itacademy.hw12.task5.hw11.service.exception.UserNotExistException;
import by.itacademy.hw12.task5.hw11.service.exception.WrongLoginException;
import by.itacademy.hw12.task5.hw11.service.exception.WrongPasswordException;

import java.util.List;
import java.util.Scanner;

public class UserService {

    private final Scanner scanner = new Scanner(System.in);
    private final List<User> users = UserRepository.getInstance().getUsers();


    public void authorization() {
        System.out.print("Логин: ");
        User user = findUser(scanner.nextLine());

        try {
            if (user == null) {
                throw new UserNotExistException("Пользователя не существует");
            }
        } catch (UserNotExistException e) {
            System.out.println(e);
            return;
        }

        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        try {
            if (user.getPassword().equals(password)) {
                System.out.println("Вы авторизованы!");
            } else {
                throw new WrongPasswordException("Неверный пароль");
            }
        } catch (WrongPasswordException e) {
            System.out.println(e);
        }
    }

    public void registration() {
        String login = null;

        boolean isLogin = false;
        while (!isLogin) {
            System.out.print("Логин: ");
            login = scanner.nextLine();

            isLogin = login.matches("[\\w+]{5,20}");

            try {
                if (!isLogin) {
                    throw new WrongLoginException("Неверный формат логина");
                }
            } catch (WrongLoginException e) {
                System.out.println(e);
            }
        }

        boolean isPassword = false;
        while (!isPassword) {
            System.out.print("Пароль: ");
            String password = scanner.nextLine();
            isPassword = password.matches("[\\w+]{8,}");
            try {
                if (isPassword) {
                    users.add(new User(login, password));
                    System.out.println("Вы зарегестрированы!");
                } else {
                    throw new WrongPasswordException("Неверный формат пароля");
                }
            } catch (WrongPasswordException e) {
                System.out.println(e);
            }
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
