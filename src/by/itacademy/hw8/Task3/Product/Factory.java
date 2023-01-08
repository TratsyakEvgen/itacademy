package by.itacademy.hw8.Task3.Product;

import by.itacademy.hw8.Task3.Product.Clothes.*;
import by.itacademy.hw8.Task3.Product.Shoes.*;

import java.util.Scanner;

public class Factory {
    public Product getProduct(ListProducts type) {
        Product product = null;
        switch (type) {
            case PRODUCT:
                product = createProduct();
                break;
            case SHOES:
                product = createShoes(createProduct());
                break;
            case BOOTS:
                product = createBoots(createShoes(createProduct()));
                break;
            case SLIPPERS:
                product = createSlippers(createShoes(createProduct()));
                break;
            case SNEAKERS:
                product = createSneakers(createShoes(createProduct()));
                break;
            case CLOTHES:
                product = createClothes(createProduct());
                break;
            case JACKETS:
                product = createJackets(createClothes(createProduct()));
                break;
            case SHIRTS:
                product = createShirts(createClothes(createProduct()));
                break;
            case TROUSERS:
                product = createTrousers(createClothes(createProduct()));
                break;
        }
        return product;
    }

    private Product createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите штрих-код: ");
        int barcode = scanner.nextInt();
        System.out.print("Введите стоимость: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите изготовителя: ");
        String producer = scanner.nextLine();
        System.out.print("Введите модель: ");
        final String model = scanner.nextLine();
        return new Product(barcode, price, producer, model);
    }

    private Shoes createShoes(Product p) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пол: ");
        String gender = scanner.nextLine();
        System.out.print("Введите размер: ");
        SizeOfShoes size = SizeOfShoes.find(scanner.nextInt());
        while (size == null) {
            System.out.println("Таких размеров не существует! Повторите ввод:");
            size = SizeOfShoes.find(scanner.nextInt());
        }
        return new Shoes(p.getBarcode(), p.getPrice(), p.getProducer(), p.getModel(), gender, size);
    }

    private Boots createBoots(Shoes s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сезон: ");
        String season = scanner.nextLine();
        return new Boots(s.getBarcode(), s.getPrice(), s.getProducer(), s.getModel(), s.getGender(), s.getSize(), season);
    }

    private Slippers createSlippers(Shoes s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите тип: ");
        String type = scanner.nextLine();
        return new Slippers(s.getBarcode(), s.getPrice(), s.getProducer(), s.getModel(), s.getGender(), s.getSize(), type);
    }

    private Sneakers createSneakers(Shoes s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите материал подошвы: ");
        String soleMaterial = scanner.nextLine();
        return new Sneakers(s.getBarcode(), s.getPrice(), s.getProducer(), s.getModel(), s.getGender(), s.getSize(), soleMaterial);
    }

    private Clothes createClothes(Product p) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пол: ");
        String gender = scanner.nextLine();
        System.out.print("Введите размер: ");
        SizeOfClothes size = SizeOfClothes.find(scanner.nextInt());
        while (size == null) {
            System.out.println("Таких размеров не существует! Повторите ввод:");
            size = SizeOfClothes.find(scanner.nextInt());
        }
        return new Clothes(p.getBarcode(), p.getPrice(), p.getProducer(), p.getModel(), gender, size);
    }

    private Jackets createJackets(Clothes s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Наличе капюшона (true/false): ");
        boolean hood = scanner.nextBoolean();
        return new Jackets(s.getBarcode(), s.getPrice(), s.getProducer(), s.getModel(), s.getGender(), s.getSize(), hood);
    }

    private Shirts createShirts(Clothes s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите тип: ");
        String type = scanner.nextLine();
        return new Shirts(s.getBarcode(), s.getPrice(), s.getProducer(), s.getModel(), s.getGender(), s.getSize(), type);
    }

    private Trousers createTrousers(Clothes s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сезон: ");
        String season = scanner.nextLine();
        return new Trousers(s.getBarcode(), s.getPrice(), s.getProducer(), s.getModel(), s.getGender(), s.getSize(), season);
    }
}
