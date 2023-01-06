package by.itacademy.hw5.Task2;


public class Phone {
    private long number;
    private String model;
    private double weight;


    Phone() {
    }

    Phone(long number, String model) {
        this.number = number;
        this.model = model;
    }

    Phone(long number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }


    public static void sendMessage(long... numbers) {
        System.out.println("Сообщение будет отправлено по номерам:");
        for (long element : numbers) {
            System.out.println(element);
        }
    }

    public static void receiveCall(String name, long number) {
        System.out.println("Звонит " + name + " Номер: " + number);
    }

}
