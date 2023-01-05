package by.itacademy.hw6;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число = ");
        int firstNumber = scanner.nextInt();
        System.out.print("Введите второе число = ");
        int secondNumber = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(firstNumber).append(" + ").append(secondNumber)
                .append(" = ").append(firstNumber + secondNumber);
        System.out.println(stringBuilder);

        replace(stringBuilder, "+", "-", firstNumber - secondNumber);
        System.out.println(stringBuilder);

        replace(stringBuilder, "-", "*", firstNumber * secondNumber);
        System.out.println(stringBuilder);

        replace(stringBuilder, "=", "равно", firstNumber * secondNumber);
        System.out.println(stringBuilder);
    }

    public static void replace(StringBuilder stringBuilder, String oldString, String newString, int result) {

        int start = stringBuilder.lastIndexOf("= ");
        stringBuilder.delete(start + 2, stringBuilder.length());
        stringBuilder.append(result);

        start = stringBuilder.indexOf(oldString);
        stringBuilder.delete(start, start + oldString.length());
        stringBuilder.insert(start, newString);
    }
}

