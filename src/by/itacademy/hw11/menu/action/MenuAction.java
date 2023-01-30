package by.itacademy.hw11.menu.action;

import by.itacademy.hw11.service.UserService;

import java.util.Scanner;

public class MenuAction {
    private final UserService userService = new UserService();
    private final Scanner scanner = new Scanner(System.in);

    public void authorization(){
        String login = entryString("Логин:");
        String password = entryString("Пароль:");
        String message = userService.authorization(login,password);
        System.out.println(message);
    }

    public void registration(){
        String login = entryString("Логин:");
        String password = entryString("Пароль:");
        String message = userService.registration(login,password);
        System.out.println(message);
    }

    private String entryString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }
}
