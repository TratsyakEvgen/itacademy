package by.itacademy.hw1516.task4.hw11.menu.action;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectAction {
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
            System.out.println("Введеная строка не является числом! Повторите ввод:");
        }
        if (action < 0 || action > 3) {
            System.out.println("Невеное действие! Повторите ввод (1-3):");
        }
    }
}
