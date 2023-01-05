package by.itacademy.hw6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);
        int maxLength = 0, start = 0, end = 0;
        while (matcher.find()) {
            int length = string.substring(matcher.start(), matcher.end()).length();
            if (length > maxLength) {
                maxLength = length;
                start = matcher.start();
                end = matcher.end();
            }
        }
        System.out.println("Найдим наибольшее количество идущих подряд цифр:");
        if (maxLength > 0) {
            System.out.println(string.substring(start, end));
        } else {
            System.out.println("Цифр в строке нет.");
        }
    }
}
