package by.itacademy.hw6;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task8 {
    public static void main(String[] args) {
        System.out.println("Введите код цвета:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (Pattern.matches("^#?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$", string)) {
            System.out.println("Введеная строка - код цвета!");
        } else {
            System.out.println("Введеная строка - не является кодом цвета!");
        }
    }
}
