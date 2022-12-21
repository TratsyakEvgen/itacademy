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


        System.out.println(firstPerson.talk(firstPerson.getFullName()) + " говорит");
        System.out.println(firstPerson.move(firstPerson.getFullName()) + " говорит");
        System.out.println(secondPerson.talk(secondPerson.getFullName()) + " говорит");
        System.out.println(secondPerson.move(secondPerson.getFullName()) + " говорит");

    }
    private static Person createPerson(){
        Scanner scanner = new Scanner(System.in);
        String fullName;
        int age;

        System.out.print("Введите имя: ");
        fullName = scanner.nextLine();
        System.out.print("Введите возраст: ");
        age = scanner.nextInt();
        scanner.nextLine();
        Person person = new Person();
        person.setFullName(fullName);
        person.setAge(age);

        return person;
    }
}
