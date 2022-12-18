package by.itacademy.hw3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число = ");
        int number = scanner.nextInt();
        System.out.println("Число "+number+" четное? " + isEven(number));
    }
    public static boolean isEven(int number){
        boolean result = false;
        if (number % 2 == 0){
            result = true;
        }
        return result;
    }
}
