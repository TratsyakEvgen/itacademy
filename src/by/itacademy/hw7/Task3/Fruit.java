package by.itacademy.hw7.Task3;

import java.util.Scanner;

public class Fruit {
    private double weight;
    private double price;

    protected void printManufacturerInfo() {
        System.out.print("Made in Belarus");
    }


    protected void setWeight(double weight) {
        verify(weight);
        this.weight = weight;
    }


    protected double calculatePrice() {
        return this.price * this.weight / 1000;
    }

    public void setPrice(double price) {
        verify(price);
        this.price = price;
    }

    public static double verify(double number) {
        Scanner scanner = new Scanner(System.in);
        while (number < 0) {
            System.out.print("Число должно быть больше 0! Повторите ввод: ");
            number = scanner.nextInt();
        }
        return number;
    }
}
