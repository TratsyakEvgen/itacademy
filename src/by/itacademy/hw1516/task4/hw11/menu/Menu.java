package by.itacademy.hw1516.task4.hw11.menu;

import by.itacademy.hw1516.task4.hw11.menu.action.MenuAction;
import by.itacademy.hw1516.task4.hw11.menu.action.SelectAction;

public class Menu {

    private final MenuAction menuAction = new MenuAction();

    public static void main(String[] args) {
        new Menu().showMenu();
    }

    private void showMenu() {
        System.out.println("Выбирите действие:\n" +
                "1 - Авторизация\n" +
                "2 - Регистарация\n" +
                "3 - Просмотр пользователей\n" +
                "4 - Выход");

        boolean isExit = false;

        while (!isExit) {
            switch (new SelectAction().getAction()) {
                case 1:
                    menuAction.authorization();
                    showMenu();
                    break;
                case 2:
                    menuAction.registration();
                    showMenu();
                    break;
                case 3:
                    menuAction.getUsersOfDateRegistration();
                    showMenu();
                    break;
                case 4:
                    isExit = true;
                    break;
            }
        }
    }

}
