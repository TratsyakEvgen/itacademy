package by.itacademy.hw7.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите температуру по Цельсиях: ");
        Celsius celsius = new Celsius();
        entryValue(celsius);
        convertAndPrint(celsius);

        System.out.print("Введите температуру по Кельвинах: ");
        Kelvin kelvin = new Kelvin();
        entryValue(kelvin);
        convertAndPrint(kelvin);

        System.out.print("Введите температуру по Фарингйту: ");
        Fahrenheit fahrenheit = new Fahrenheit();
        entryValue(fahrenheit);
        convertAndPrint(fahrenheit);
    }

    public static void convertAndPrint(Degree degree) {
        System.out.println("Температура по Цельсию: " + degree.convertToCelsius());
        System.out.println("Температура по Кельвину: " + degree.convertToKelvin());
        System.out.println("Температура по Фаренгейту: " + degree.convertToFahrenheit());
        System.out.println();
    }

    public static void entryValue(Degree degree) {
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextInt();
        double minValue = degree.getMinValue();
        while (value < minValue) {
            System.out.print(value + " < " + minValue + "! Повторите ввод: ");
            value = scanner.nextDouble();
        }
        degree.setValue(value);
    }

}
