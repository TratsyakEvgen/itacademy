package by.itacademy.hw6;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task9 {
    public static void main(String[] args) {
        System.out.println("Введите email:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (Pattern.matches("^[\\w-.]+@[\\w-.]+[a-zA-Z]{2,6}$", string)) {
            System.out.println("Введеная строка - email!");
        } else {
            System.out.println("Введеная строка - не является email!");
        }
    }
}
