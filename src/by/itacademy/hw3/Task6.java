package by.itacademy.hw3;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите три стороны треугольника");
        System.out.print("Сторона а = ");
        int a = scanner.nextInt();
        System.out.print("Сторона b = ");
        int b = scanner.nextInt();
        System.out.print("Сторона c = ");
        int c = scanner.nextInt();
        if (a + b > c && a + c > b && c + b > a) {
            System.out.println("Треугольник с заданными сторонами может существовать");
        } else {
            System.out.println("Треугольник с заданными сторонами не может существовать");
        }
    }
}
