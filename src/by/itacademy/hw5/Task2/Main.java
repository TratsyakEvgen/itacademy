package by.itacademy.hw5.Task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long number;
        String name;


        System.out.println("Создаем телефоны: ");
        Phone phone = creatPhone();

        Phone firstPhone = new Phone();
        firstPhone.setNumber(phone.getNumber());
        firstPhone.setModel(phone.getModel());
        firstPhone.setWeight(phone.getWeight());

        phone = creatPhone();
        Phone secondPhone = new Phone(phone.getNumber(), phone.getModel(), phone.getWeight());

        phone = creatPhone();
        Phone tridPhone = new Phone(phone.getNumber(), phone.getModel());
        tridPhone.setWeight(phone.getWeight());


        System.out.print("Укажите имя контакта входящего вызова: ");
        Phone.receiveCall(enterName());


        System.out.print("Укажите имя контакта входящего вызова: ");
        name = enterName();
        System.out.print("Укажите номер входящего вызова: ");
        number = enterNumber();
        Phone.receiveCall(name, number);


        Phone.sendMessage(enterNumbersOfMessage());


        System.out.println("Выведем номер первого телефона: " + firstPhone.getNumber());
        System.out.println("Выведем номер вторго телефона: " + secondPhone.getNumber());
        System.out.println("Выведем номер третьего телефона: " + tridPhone.getNumber());
    }


    private static Phone creatPhone() {
        Scanner scanner = new Scanner(System.in);
        long number;
        String model;
        double weight;


        System.out.print("Номер (12 цифр): ");
        number = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Модель: ");
        model = scanner.nextLine();
        System.out.print("Вес: ");
        weight = scanner.nextDouble();
        scanner.nextLine();

        Phone phone = new Phone();
        phone.setNumber(number);
        phone.setModel(model);
        phone.setWeight(weight);

        return phone;
    }


    private static long enterNumber() {
        long number;
        Scanner scanner = new Scanner(System.in);

        number = scanner.nextLong();
        scanner.nextLine();

        while (number <= 100_00_000_00_00L || number >= 999_99_999_99_99L) {
            System.out.print("Неверный номер! Повтороите ввод: ");
            number = scanner.nextLong();
            scanner.nextLine();
        }
        return number;
    }

    private static String enterName() {
        String name;
        Scanner scanner = new Scanner(System.in);

        name = scanner.nextLine();
        while (name.length() == 0) {
            System.out.print("Имя не может быть пустым! Повтороите ввод: ");
            name = scanner.nextLine();
        }
        return name;
    }

    private static long[] enterNumbersOfMessage() {
        int numberOfMessage = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите количество номеров для рассылки сообщений: ");

        numberOfMessage = scanner.nextInt();
        while (numberOfMessage <= 1) {
            System.out.print("Количество номеров должно быть больше 1! Повторите ввод: ");
            numberOfMessage = scanner.nextInt();
        }
        scanner.nextLine();

        long[] numbers = new long[numberOfMessage];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Введите номер " + (i + 1) + " для рассылки: ");
            numbers[i] = enterNumber();
        }

        return numbers;
    }

}
