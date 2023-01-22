package by.itacademy.hw11.menu;

import by.itacademy.hw11.menu.action.SelectAction;
import by.itacademy.hw11.service.UserService;

public class Menu {

    private final UserService userService = new UserService();

    public static void main(String[] args) {
        new Menu().showMenu();
    }

    private void showMenu() {
        System.out.println("Выбирите действие:\n" +
                "1 - Авторизация\n" +
                "2 - Регистарация\n" +
                "3 - Выход");
        boolean isExit = false;

        while (!isExit) {
            switch (new SelectAction().getAction()) {
                case 1:
                    userService.authorization();
                    showMenu();
                    break;
                case 2:
                    userService.registration();
                    showMenu();
                    break;
                case 3:
                    isExit = true;
                    break;
            }
        }
    }

}
