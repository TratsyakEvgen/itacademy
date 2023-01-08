package by.itacademy.hw8.Task3;


import by.itacademy.hw8.Task3.Product.Clothes.*;
import by.itacademy.hw8.Task3.Product.Factory;
import by.itacademy.hw8.Task3.Product.ListProducts;
import by.itacademy.hw8.Task3.Product.Product;
import by.itacademy.hw8.Task3.Product.Shoes.Boots;
import by.itacademy.hw8.Task3.Product.Shoes.SizeOfShoes;
import by.itacademy.hw8.Task3.Product.Shoes.Slippers;
import by.itacademy.hw8.Task3.Product.Shoes.Sneakers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Jackets(12345, 199.99, "Китай", "MONCLER", "М", SizeOfClothes.M, true));
        products.add(new Jackets(12432, 89.99, "Беларусь", "Алеся", "Ж", SizeOfClothes.XS, true));
        products.add(new Shirts(12433, 6.99, "РФ", "Рубаха", "М", SizeOfClothes.SM, "Классика"));
        products.add(new Shirts(12493, 68.99, "Германия", "Sanctions", "Ж", SizeOfClothes.S, "Деловой стиль"));
        products.add(new Trousers(124921, 8.99, "РФ", "Ватники", "М", SizeOfClothes.XL, "Лето"));
        products.add(new Trousers(124943, 100.99, "Нидерланды", "NL Operations", "М", SizeOfClothes.XXL, "Лето"));
        products.add(new Boots(1943, 0.99, "РФ", "Валенки", "Ж", SizeOfShoes.S, "Лето"));
        products.add(new Boots(19675, 0.99, "РФ", "Валенки", "Ж", SizeOfShoes.XXS, "Осень"));
        products.add(new Slippers(19677, 10.99, "Китай", "Noname", "М", SizeOfShoes.M, "Домашние"));
        products.add(new Sneakers(19611, 888.99, "США", "Gorilla Wear", "М", SizeOfShoes.S, "Полиуретан"));


        System.out.println("Добро пожаловать в магазин!");
        startMenu(products);

    }

    public static void startMenu(ArrayList<Product> products) {
        System.out.println("Нажмите чтобы перейти \n" +
                "1 Добавть товар\n" +
                "2 Поиск товара\n" +
                "3 Купить товар\n" +
                "0 Выход");
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        while (action < 0 || action > 3) {
            action = scanner.nextInt();
        }
        switch (action) {
            case 1:
                addProduct(products);
                break;
            case 2:
                findMenu(products);
                break;
            case 3:
                buy(products);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public static void findMenu(ArrayList<Product> products) {
        System.out.println("Нажмите чтобы перейти \n" +
                "1 Просмотреть весь товар\n" +
                "2 Поиск товара по фильтру\n" +
                "0 Назад");
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        while (action < 0 || action > 2) {
            action = scanner.nextInt();
        }
        switch (action) {
            case 1:
                for (Product obj : products) {
                    System.out.println(obj);
                }
                startMenu(products);
                break;
            case 2:
                findProduct(products);
                break;
            case 0:
                startMenu(products);
                break;
        }
    }

    public static void findProduct(ArrayList<Product> products) {
        Factory factory = new Factory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите товар который хотите найти:");
        ListProducts.printTitles(true);
        ListProducts.printTitles(false);
        System.out.println();
        String name = scanner.nextLine();
        ListProducts listProducts = ListProducts.find(name);
        if (listProducts != null) {
            System.out.println("Введите шаблон для поиска:");
            Product product = factory.getProduct(listProducts);
            System.out.println("\nРезультыты поиска:\n");
            for (Product obj : products) {
                if (product.equals(obj)) {
                    System.out.println(obj);
                }
            }
        } else {
            System.out.println("Такого товара не существует!");
        }
        startMenu(products);
    }

    public static void addProduct(ArrayList<Product> products) {
        Factory factory = new Factory();
        boolean add = true;
        while (add) {
            System.out.println("Добавить новый товар (true/false)?");
            Scanner scanner = new Scanner(System.in);
            add = scanner.nextBoolean();
            scanner.nextLine();
            if (add) {
                System.out.println("Введите товар который хотите добавить:");
                ListProducts.printTitles(false);
                String name = scanner.nextLine();
                ListProducts listProducts = ListProducts.find(name);
                if (listProducts != null) {
                    products.add(factory.getProduct(listProducts));
                } else {
                    System.out.println("Такого товара не существует!");
                }
            }
        }
        startMenu(products);
    }

    public static void buy(ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи штрих-код товара который хотите купить:");
        int barcode = scanner.nextInt();
        for (Product obj : products) {
            if (obj.getBarcode() == barcode) {
                System.out.println("Поздравляем с покупкой!");
                System.out.println(obj);
                products.remove(obj);
                break;
            }
        }
        startMenu(products);
    }


}
