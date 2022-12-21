package by.itacademy.hw5.Task1;

import java.util.Scanner;

public class Person {
    private String fullName;
    private int age;
    private Scanner scanner = new Scanner(System.in);


    Person() {
    }

    Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String move(String fullName) {
        return fullName;
    }

    public String talk(String fullName) {
        return fullName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFullName(String fullName) {
        while (fullName.length() == 0) {
            System.out.print("Имя не может быть пустым! Повторите ввод: ");
            fullName = scanner.nextLine();
        }
        this.fullName = fullName;
    }

    public void setAge(int age) {
        while (age < 0) {
            System.out.print("Возраст не может быть меньше 0! Повторите ввод: ");
            age = scanner.nextInt();
            scanner.nextLine();
        }
        this.age = age;
    }

}
