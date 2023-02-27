package by.itacademy.hw19.task1.menu.action;

import by.itacademy.hw19.task1.interfaces.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputValue {
    private Scanner scanner = new Scanner(System.in);
    private final Logger logger;

    public InputValue(Logger logger) {
        this.logger = logger;
    }

    public int entryValidInt(String message, int start, int end) {
        System.out.print(message);
        boolean valid = false;
        int value = 0;
        while (!valid) {
            try {
                value = scanner.nextInt();
                scanner.nextLine();
                if (value >= start && value <= end) {
                    valid = true;
                } else {
                    System.out.println("Неверный номер! Повторите ввод:");
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
                scanner = new Scanner(System.in);
            }
        }
        return value;
    }

    public String entryValidString(String message, String regex) {
        System.out.print(message);
        boolean valid = false;
        String value = null;
        while (!valid) {
            try {
                value = scanner.nextLine();
                if (value.matches(regex)) {
                    valid = true;
                } else {
                    System.out.println("Неверный формат!(" + regex + ") Повторите ввод:");
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
                scanner = new Scanner(System.in);
            }
        }
        return value;
    }


    public LocalDateTime entryValidDate(String message) {
        System.out.print(message);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        boolean valid = false;
        String value = "";
        while (!valid) {
            try {
                value = scanner.nextLine();
                formatter.parse(value);
                valid = true;
            } catch (NoSuchElementException | IllegalStateException | DateTimeParseException e) {
                logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
                scanner = new Scanner(System.in);
            }
        }
        return LocalDateTime.parse(value, formatter);
    }

    public String entryString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public boolean entryBoolean(String message) {
        switch (entryValidInt(message,1,2)){
            case 1:
                return true;
            case 2:
                return false;
        }
        return false;
    }

}
