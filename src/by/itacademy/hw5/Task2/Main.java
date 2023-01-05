package by.itacademy.hw5.Task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
        Phone.receiveCall(enterString());


        System.out.print("Укажите имя контакта входящего вызова: ");
        String name = enterString();
        System.out.print("Укажите номер входящего вызова: ");
        long number = enterNumber();
        Phone.receiveCall(name, number);


        Phone.sendMessage(enterNumbersOfMessage());


        System.out.println("Выведем номер первого телефона: " + firstPhone.getNumber());
        System.out.println("Выведем номер вторго телефона: " + secondPhone.getNumber());
        System.out.println("Выведем номер третьего телефона: " + tridPhone.getNumber());
    }


    private static Phone creatPhone() {

        System.out.print("Номер (12 цифр): ");
        long number = enterNumber();
        System.out.print("Модель: ");
        String model = enterString();
        System.out.print("Вес: ");
        double weight = enterWeight();

        Phone phone = new Phone();
        phone.setNumber(number);
        phone.setModel(model);
        phone.setWeight(weight);

        return phone;
    }


    private static long enterNumber() {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        while (number <= 100_00_000_00_00L || number >= 999_99_999_99_99L) {
            System.out.print("Неверный номер! Повтороите ввод: ");
            number = scanner.nextLong();
        }
        scanner.nextLine();
        return number;
    }

    private static String enterString() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (string.length() == 0) {
            System.out.print("Строка не может быть пустой! Повтороите ввод: ");
            string = scanner.nextLine();
        }
        return string;
    }

    private static double enterWeight() {
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        while (weight <= 0) {
            System.out.print("Вес должен быть больше 0! Повтороите ввод: ");
            weight = scanner.nextDouble();
            scanner.nextLine();
        }
        return weight;
    }


    private static long[] enterNumbersOfMessage() {
        int numberOfMessage;
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
