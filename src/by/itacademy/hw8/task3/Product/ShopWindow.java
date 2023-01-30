package by.itacademy.hw8.task3.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopWindow {

    private final ArrayList<Product> products = new ArrayList<>();

    public ShopWindow() {
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public void addProduct() {
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
    }

    public void findProduct() {
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
    }

    public void buy() {
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
    }

    public void printProducts() {
        for (Product obj : products) {
            System.out.println(obj);
        }
    }
}
