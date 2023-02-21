package by.itacademy.hw19.task1.entity;

public class Client {
    private String firsName;
    private String lastName;
    private String identification;
    private int age;
    private String country;
    private String phoneNumber;

    public Client(String firsName, String lastName, String identification, int age, String country, String phoneNumber) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.identification = identification;
        this.age = age;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
