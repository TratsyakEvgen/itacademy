package by.itacademy.hw12.task5.hw11.menu;

import by.itacademy.hw12.task5.hw11.menu.action.SelectAction;
import by.itacademy.hw12.task5.hw11.service.UserService;
import by.itacademy.hw12.task5.logger.ConsolLogger;
import by.itacademy.hw12.task5.logger.FileLogger;

public class Menu {
    private final FileLogger fileLogger = new FileLogger(Menu.class);
    private final ConsolLogger consolLogger = new ConsolLogger(Menu.class);
    private final UserService userService = new UserService();

    public static void main(String[] args) {
        new Menu().showMenu();
    }

    private void showMenu() {

        String action = "1 - Авторизация\n" +
                "2 - Регистарация\n" +
                "3 - Выход";

        String infoMessage = "Пользователь выбирает действие:\n";
        consolLogger.info(infoMessage + action);
        fileLogger.info(infoMessage + action);

        System.out.println("Выбирите действие:\n" + action);
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
