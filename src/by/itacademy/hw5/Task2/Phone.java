package by.itacademy.hw5.Task2;

import java.util.Scanner;

public class Phone {
    private long number;
    private String model;
    private double weight;

    Scanner scanner = new Scanner(System.in);

    Phone() {
    }

    Phone(long number, String model) {
        this.number = number;
        this.model = model;
    }

    Phone(long number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public static void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }


    public static void sendMessage(long... numbers) {
        System.out.println("Сообщение будет отправлено по номерам:");
        for (long element : numbers) {
            System.out.println(element);
        }
    }

    public static void receiveCall(String name, long number) {
        System.out.println("Звонит " + name + " Номер: " + number);
    }

    public long getNumber() {
        return this.number;
    }

    public String getModel() {
        return this.model;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setNumber(long number) {
        while (number <= 100_00_000_00_00L || number >= 999_99_999_99_99L) {
            System.out.print("Неверный номер! Повтороите ввод: ");
            number = scanner.nextLong();
            scanner.nextLine();
        }
        this.number = number;
    }


    public void setModel(String model) {
        while (model.length() == 0) {
            System.out.print("Модель не может быть пустой! Повтороите ввод: ");
            model = scanner.nextLine();
        }
        this.model = model;
    }

    public void setWeight(double weight) {
        while (weight <= 0) {
            System.out.print("Вес должен быть больше 0! Повтороите ввод: ");
            weight = scanner.nextDouble();
            scanner.nextLine();
        }
        this.weight = weight;
    }

}
