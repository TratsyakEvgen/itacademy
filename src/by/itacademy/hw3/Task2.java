package by.itacademy.hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число = ");
        int number = scanner.nextInt();
        if (!isEven(number) && !isNegative(number)){
            System.out.println("Число "+number+" вляется нечетным положительным");
        }
        if (isEven(number) && isNegative(number)){
            System.out.println("Число "+number+" вляется четным отрицательным");
        }
    }
    public static boolean isNegative(int number){
        boolean result = false;
        if (number < 0){
            result = true;
        }
        return result;
    }
    public static boolean isEven(int number){
        boolean result = false;
        if (number % 2 == 0){
            result = true;
        }
        return result;
    }
}
