package by.itacademy.hw19.task1.util;

import by.itacademy.hw19.task1.logger.Logger;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class EntryMenuUtil {
    private final Scanner scanner = new Scanner(System.in);
    private final Logger logger;

    public EntryMenuUtil(Logger logger) {
        this.logger = logger;
    }

    public int entryVerifyInt(String message, int start, int end) {
        System.out.print(message);
        boolean verify = false;
        int value = 0;
        while (!verify) {
            try {
                value = scanner.nextInt();
                scanner.nextLine();
                if (value >= start && value <= end) {
                    verify = true;
                } else {
                    System.out.println("Неверный номер! Повторите ввод:");
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
            }
        }
        return value;
    }

    public String entryVerifyString(String message, String regex) {
        System.out.print(message);
        boolean verify = false;
        String value = null;
        while (!verify) {
            try {
                value = scanner.nextLine();
                if (value.matches(regex)) {
                    verify = true;
                } else {
                    System.out.println("Неверный формат!(" + regex + ") Повторите ввод:");
                    System.out.println();
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
            }
        }
        return value;
    }

    public String entryString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

}
