package by.itacademy.hw7.Task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<Flower> bouquet = new ArrayList<>();

        System.out.println("Добавим розы в букет");
        addFlowersToBouquet("Rose", bouquet);
        System.out.println("Добавим тюльпаны в букет");
        addFlowersToBouquet("Tulip", bouquet);
        System.out.println("Добавим кактусы в букет");
        addFlowersToBouquet("Cactus", bouquet);


        if (!bouquet.isEmpty()) {
            System.out.print("Цвета используемые в букете: ");

            int max = 0;
            int days;

            for (int i = 0; i < bouquet.size(); i++) {
                int count = 0;
                String color = bouquet.get(i).getColor();
                days = bouquet.get(i).getDaysOfLife();

                for (int j = i; j < bouquet.size(); j++) {
                    if (color.equals(bouquet.get(j).getColor())) {
                        count++;
                    }
                }

                if (count == 1) {
                    System.out.print(color + " ");
                }
                if (max < days) {
                    max = days;
                }
            }

            System.out.printf("\nБукет полностью завянет на %d день", max);
        }

    }


    public static void addFlowersToBouquet(String flower, ArrayList<Flower> bouquet) {

        Scanner scanner = new Scanner(System.in);

        int number = entryPositiveNumber("Укажите количество в букете: ");

        for (int i = 0; i < number; i++) {
            System.out.print("Укажите цвет: ");
            String color = scanner.next();
            int days = entryPositiveNumber("Укажите сколько дней простоит цветок: ");

            if (flower.equals("Rose")) {
                bouquet.add(new Rose(color, days));
            } else if (flower.equals("Tulip")) {
                bouquet.add(new Tulip(color, days));
            } else {
                bouquet.add(new Cactus(color, days));
            }

        }
        System.out.println();
    }


    public static int entryPositiveNumber(String textMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(textMessage);
        int number = scanner.nextInt();
        while (number < 0) {
            System.out.print("Число должно быть больше 0! Повторите ввод: ");
            number = scanner.nextInt();
        }
        return number;
    }
}
