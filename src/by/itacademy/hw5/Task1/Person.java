package by.itacademy.hw5.Task1;

public class Person {
    private String fullName;
    private int age;

    Person() {
    }

    Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void move() {
        System.out.println(this.fullName + " говорит");
    }

    public void talk() {
        System.out.println(this.fullName + " говорит");
    }


}
