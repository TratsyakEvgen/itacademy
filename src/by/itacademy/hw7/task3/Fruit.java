package by.itacademy.hw7.task3;

public class Fruit {
    private double weight;
    private double price;
    private final String enumeratedName;

    public Fruit(double weight, double price, String enumeratedName) {
        this.weight = weight;
        this.price = price;
        this.enumeratedName = enumeratedName;
    }

    public Fruit(String enumeratedName) {
        this.enumeratedName = enumeratedName;
    }

    public String getEnumeratedName() {
        return enumeratedName;
    }

    protected void printManufacturerInfo() {
        System.out.print("Made in Belarus");
    }

    protected double calculatePrice() {
        return this.price * this.weight;
    }




}
