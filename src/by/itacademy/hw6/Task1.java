package by.itacademy.hw6;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ненормированную строку:");
        String string = scanner.nextLine();
        string = string.trim().replaceAll("\\s+", " ");
        System.out.println("Выведем строку:");
        System.out.println(string);
    }
}
