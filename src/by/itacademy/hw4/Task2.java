package by.itacademy.hw4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите чило a = ");
        int number = Math.abs(scanner.nextInt());
        int summ = 0;
        int multiplication;
        multiplication = number == 0 ? 0 : 1;
        while (number / 10 != 0 || number % 10 != 0) {
            summ += number % 10;
            multiplication *= number % 10;
            number /= 10;
        }
        System.out.println("Сумма цифр числа а = " + summ);
        System.out.println("Произведение цифр числа а = " + multiplication);
    }
}
