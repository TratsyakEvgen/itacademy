package by.itacademy.hw7.Task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Fruit> basket = new ArrayList<>();


        setInfoFruit("яблок", basket);
        setInfoFruit("груш", basket);
        setInfoFruit("абрикосов", basket);

        double sumPrice = 0;
        double sumPriceApple = 0;
        double sumPricePear = 0;
        double sumPriceApricot = 0;
        for (Fruit object : basket) {
            sumPrice += object.calculatePrice();
            switch (object.getClass().getSimpleName()) {
                case "Apple":
                    sumPriceApple = object.calculatePrice();
                    break;
                case "Pear":
                    sumPricePear = object.calculatePrice();
                    break;
                case "Apricot":
                    sumPriceApricot = object.calculatePrice();
                    break;
            }
        }
        System.out.println("Стоимость корзины фруктов: " + sumPrice);
        System.out.println("Стоимость яблок в корзине: " + sumPriceApple);
        System.out.println("Стоимость груш в корзине: " + sumPricePear);
        System.out.println("Стоимость абрикосов в корзине: " + sumPriceApricot);
    }

    public static void setInfoFruit(String nameFruit, ArrayList<Fruit> basket) {
        double price = setNumber("Укажите цену " + nameFruit + ": ");
        int number = (int) setNumber("Укажите количество " + nameFruit + " в корзине: ");
        addFruit(nameFruit, basket, price, number);
    }

    public static void addFruit(String nameFruit, ArrayList<Fruit> basket, double price, int number) {
        Fruit fruit;
        for (int i = 0; i < number; i++) {
            switch (nameFruit) {
                case "яблок":
                    fruit = new Apple();
                    break;
                case "груш":
                    fruit = new Pear();
                    break;
                default:
                    fruit = new Apricot();
                    break;
            }
            double weight = setNumber("Укажите вес " + (i + 1) + "-го фрукта: ");
            fruit.setWeight(weight);
            fruit.setPrice(price);
            basket.add(fruit);
        }
    }

    public static double setNumber(String textMessage) {
        System.out.print(textMessage);
        Scanner scanner = new Scanner(System.in);
        return Fruit.verify(scanner.nextInt());
    }

}
