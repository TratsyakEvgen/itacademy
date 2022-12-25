package by.itacademy.hw4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите чило a = ");
        int number = scanner.nextInt();
        if (number > 0) {
            long factorial = 1L;
            for (int i = number; i > 1; i--) {
                factorial *= i;
            }
            System.out.println("Факториал числа а = " + factorial);
        } else {
            System.out.println("Число а = " + number + " не является натуральным");
        }
    }
}
