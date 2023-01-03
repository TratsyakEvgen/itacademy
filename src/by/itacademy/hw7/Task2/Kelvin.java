package by.itacademy.hw7.Task2;

import java.util.Scanner;

public class Kelvin extends Degree {
    public double convertToCelsius(double value) {
        return value - 273.15;
    }

    public double convertToKelvin(double value) {
        return value;
    }

    public double convertToFahrenheit(double value) {
        return (value - 273.15) * 9 / 5 + 32;
    }

    public void setValue(double value) {
        Scanner scanner = new Scanner(System.in);
        while (value < 0) {
            System.out.print("Неверное значение! Повторите ввод: ");
            value = scanner.nextDouble();
        }
        super.setValue(value);
    }
}
