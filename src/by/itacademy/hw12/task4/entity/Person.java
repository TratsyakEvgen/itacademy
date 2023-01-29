package by.itacademy.hw12.task4.entity;

public class Person {
    private final String name;
    private final String surname;
    private final int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "name = " + name + "\n" +
                "surname = " + surname + "\n" +
                "age = " + age + "\n";
    }
}
