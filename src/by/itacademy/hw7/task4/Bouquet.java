package by.itacademy.hw7.task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Bouquet {
    ArrayList<Flower> bouquet = new ArrayList<>();

    public Bouquet() {
    }

    public String getColorsAndDeadLine() {
        if (!bouquet.isEmpty()) {
            StringBuilder colors = new StringBuilder();
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
                    colors.append(color).append(" ");
                }
                if (max < days) {
                    max = days;
                }
            }
            return String.format("Цвета используемые в букете: %s \nБукет полностью завянет на %d день",colors, max);
        }
        return "В букете нет цветов";
    }

    public void addFlowersToBouquet(String flower) {

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


    private int entryPositiveNumber(String textMessage) {
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
