package by.itacademy.hw5.Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Создаим первого человека:");
        Person person = createPerson();
        Person firstPerson = new Person();
        firstPerson.setFullName(person.getFullName());
        firstPerson.setAge(person.getAge());

        System.out.println("Создаим второго человека:");
        person = createPerson();
        Person secondPerson = new Person(person.getFullName(), person.getAge());

        firstPerson.talk();
        firstPerson.move();
        secondPerson.talk();
        secondPerson.move();

    }

    private static Person createPerson() {
        String fullName = enterName("Введите имя: ");
        int age = enterAge("Введите возраст: ");
        Person person = new Person();
        person.setFullName(fullName);
        person.setAge(age);
        return person;
    }

    public static int enterAge(String textMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(textMessage);
        int age = scanner.nextInt();
        while (age < 0) {
            System.out.print("Возраст не может быть меньше 0! Повторите ввод: ");
            age = scanner.nextInt();
        }
        return age;
    }

    public static String enterName(String textMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(textMessage);
        String fullName = scanner.nextLine();
        while (fullName.length() == 0) {
            System.out.print("Имя не может быть пустым! Повторите ввод: ");
            fullName = scanner.nextLine();
        }
        return fullName;
    }
}
