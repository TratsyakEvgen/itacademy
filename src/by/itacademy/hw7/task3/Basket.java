package by.itacademy.hw7.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basket {
    private final List<Fruit> basket = new ArrayList<>();

    public Basket() {
    }

    public void addFruitsToBasket(Fruit someFruit) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите цену " + someFruit.getEnumeratedName() + ": ");
        double price = entryPositiveNumber(scanner.nextDouble());
        System.out.print("Укажите количество " + someFruit.getEnumeratedName() + " в корзине: ");
        int number = entryPositiveNumber(scanner.nextInt());
        for (int i = 0; i < number; i++) {
            System.out.print("Укажите вес " + (i + 1) + "-го фрукта: ");
            double weight = entryPositiveNumber(scanner.nextDouble());
            Fruit fruit;

            if (someFruit instanceof Apple) {
                fruit = new Apple(weight, price);
            } else if (someFruit instanceof Pear) {
                fruit = new Pear(weight, price);
            } else {
                fruit = new Apricot(weight, price);
            }

            basket.add(fruit);
        }
    }

    public double getSumPriceInBasket(String className) {
        double sumPrice = 0;
        for (Fruit fruit : basket) {
            if (fruit.getClass().getSimpleName().equals(className)) {
                sumPrice += fruit.calculatePrice();
            }
        }
        return sumPrice;
    }

    public double getSumPriceInBasket() {
        double sumPrice = 0;
        for (Fruit fruit : basket) {
            sumPrice += fruit.calculatePrice();
        }
        return sumPrice;
    }

    private double entryPositiveNumber(double number) {
        while (number < 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Число должно быть больше 0! Повторите ввод: ");
            number = scanner.nextDouble();
        }
        return number;
    }

    private int entryPositiveNumber(int number) {
        while (number < 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Число должно быть больше 0! Повторите ввод: ");
            number = scanner.nextInt();
        }
        return number;
    }
}
