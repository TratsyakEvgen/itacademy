package by.itacademy.hw3;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите три неравных между собой числа");
        System.out.print("a = ");
        int a = scanner.nextInt();
        System.out.print("b = ");
        int b = scanner.nextInt();
        System.out.print("c = ");
        int c = scanner.nextInt();

        if (a != b && a != c && b != c) {
            if (a > b && a > c && b > c) {
                System.out.println("Выведем числа по возростанию: " + c + ", " + b + ", " + a);
            } else if (a > b && a > c && c > b) {
                System.out.println("Выведем числа по возростанию: " + b + ", " + c + ", " + a);
            } else if (b > c && b > a && a > c) {
                System.out.println("Выведем числа по возростанию: " + c + ", " + a + ", " + b);
            } else if (b > c && b > a && c > a) {
                System.out.println("Выведем числа по возростанию: " + a + ", " + c + ", " + b);
            } else if (c > a && c > b && b > a) {
                System.out.println("Выведем числа по возростанию: " + a + ", " + b + ", " + c);
            } else {
                System.out.println("Выведем числа по возростанию: " + b + ", " + a + ", " + c);
            }
        } else {
            System.out.println("Есть равные числа");
        }
    }
}
