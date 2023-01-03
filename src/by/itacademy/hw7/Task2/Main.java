package by.itacademy.hw7.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите температуру по Цельсиях: ");
        Celsius celsius = new Celsius();
        celsius.setValue(scanner.nextDouble());
        ConvertAndPrint(celsius);

        System.out.print("Введите температуру по Кельвинах: ");
        Kelvin kelvin = new Kelvin();
        kelvin.setValue(scanner.nextDouble());
        ConvertAndPrint(kelvin);

        System.out.print("Введите температуру по Фарингйту: ");
        Fahrenheit fahrenheit = new Fahrenheit();
        fahrenheit.setValue(scanner.nextDouble());
        ConvertAndPrint(fahrenheit);
    }

    public static void ConvertAndPrint(Degree degree) {
        System.out.println("Температура по Цельсию: " + degree.convertToCelsius(degree.getValue()));
        System.out.println("Температура по Кельвину: " + degree.convertToKelvin(degree.getValue()));
        System.out.println("Температура по Фаренгейту: " + degree.convertToFahrenheit(degree.getValue()));
        System.out.println();
    }
}
