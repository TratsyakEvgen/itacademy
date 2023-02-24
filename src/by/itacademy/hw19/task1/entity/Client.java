package by.itacademy.hw19.task1.entity;

import java.io.Serializable;

public class Client implements Serializable {
    private String firstName;
    private String lastName;
    private String identification;
    private int age;
    private String country;
    private String phoneNumber;

    public Client(String firstName, String lastName, String identification, int age, String country, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.age = age;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + "\n" +
               "Фамилия: " + lastName + "\n" +
               "Номер паспорта: " + identification + "\n" +
               "Возраст: " + age + "\n" +
               "Страна: " + country + "\n" +
               "Номер телефона: " + phoneNumber;
    }
}
