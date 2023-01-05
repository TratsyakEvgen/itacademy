package by.itacademy.hw7.Task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Fruit> basket = new ArrayList<>();


        addFruitsToBasket(new Apple(), basket);
        addFruitsToBasket(new Pear(), basket);
        addFruitsToBasket(new Apricot(), basket);


        System.out.println("Стоимость корзины фруктов: " + getSumPriceInBasket(basket));
        System.out.println("Стоимость яблок в корзине: " + getSumPriceInBasket(Apple.class.getSimpleName(),basket));
        System.out.println("Стоимость груш в корзине: " + getSumPriceInBasket(Pear.class.getSimpleName(),basket));
        System.out.println("Стоимость абрикосов в корзине: " + getSumPriceInBasket(Apricot.class.getSimpleName(),basket));
    }


    public static void addFruitsToBasket(Fruit someFruit, ArrayList<Fruit> basket) {

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

    public static double getSumPriceInBasket(String className,ArrayList<Fruit> basket){
        double sumPrice = 0;
        for (Fruit fruit : basket) {
            if (fruit.getClass().getSimpleName().equals(className)) {
                sumPrice += fruit.calculatePrice();
            }
        }
        return sumPrice;
    }

    public static double getSumPriceInBasket(ArrayList<Fruit> basket){
        double sumPrice = 0;
        for (Fruit fruit : basket) {
                sumPrice += fruit.calculatePrice();
        }
        return sumPrice;
    }

    public static double entryPositiveNumber(double number) {
        while (number < 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Число должно быть больше 0! Повторите ввод: ");
            number = scanner.nextDouble();
        }
        return number;
    }

    public static int entryPositiveNumber(int number) {
        while (number < 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Число должно быть больше 0! Повторите ввод: ");
            number = scanner.nextInt();
        }
        return number;
    }

}
