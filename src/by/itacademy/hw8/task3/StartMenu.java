package by.itacademy.hw8.task3;

import by.itacademy.hw8.task3.Product.ShopWindow;

import java.util.Scanner;

public class StartMenu {
    private final ShopWindow shopWindow;

    public StartMenu(ShopWindow shopWindow) {
        this.shopWindow = shopWindow;
    }

    public void start() {
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
                this.shopWindow.addProduct();
                this.start();
                break;
            case 2:
                findMenu();
                break;
            case 3:
                this.shopWindow.buy();
                this.start();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    private void findMenu() {
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
                this.shopWindow.printProducts();
                this.start();
                break;
            case 2:
                this.shopWindow.findProduct();
                this.start();
                break;
            case 0:
                this.start();
                break;
        }
    }
}
