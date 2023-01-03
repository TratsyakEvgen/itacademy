package by.itacademy.hw7.Task2;

import java.util.Scanner;

public class Fahrenheit extends Degree {
    public double convertToCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    public double convertToKelvin(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }

    public double convertToFahrenheit(double value) {
        return value;
    }

    public void setValue(double value) {
        Scanner scanner = new Scanner(System.in);
        while (value < -459.67) {
            System.out.print("Неверное значение! Повторите ввод: ");
            value = scanner.nextDouble();
        }
        super.setValue(value);
    }
}
