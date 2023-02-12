package by.itacademy.hw12.task5.hw11.menu.action;

import by.itacademy.hw12.task5.logger.ConsolLogger;
import by.itacademy.hw12.task5.logger.FileLogger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectAction {

    private final FileLogger fileLogger = new FileLogger(SelectAction.class);
    private final ConsolLogger consolLogger = new ConsolLogger(SelectAction.class);
    private final Scanner scanner = new Scanner(System.in);

    private int action;

    public SelectAction() {
        selectAction();
    }

    public int getAction() {
        return action;
    }

    private void selectAction() {
        action = 0;
        try {
            action = scanner.nextInt();
        } catch (InputMismatchException e) {
            String errorMessage = "Введеная строка не является числом! Повторите ввод:";
            consolLogger.error(errorMessage);
            fileLogger.error(errorMessage);
        }
        if (action < 0 || action > 3) {
            String warmMessage = "Невеное действие! Повторите ввод (1-3):";
            consolLogger.warm(warmMessage);
            fileLogger.warm(warmMessage);
        }
    }
}
