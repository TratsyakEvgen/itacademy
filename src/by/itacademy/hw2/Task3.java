package by.itacademy.hw2;

public class Task3 {
    public static void main(String[] args) {
        long seconds =54353421L;
        long saveSeconds = seconds;
        int secondsInPeriod = 60 * 60 * 24 * 7;
        long weeks = seconds / secondsInPeriod;
        seconds %= secondsInPeriod;
        secondsInPeriod /= 7;
        long days = seconds / secondsInPeriod;
        seconds %= secondsInPeriod;
        secondsInPeriod /= 24;
        long hours = seconds / secondsInPeriod;
        seconds %= secondsInPeriod;
        secondsInPeriod /= 60;
        long minutes = seconds / secondsInPeriod;
        seconds %= secondsInPeriod;
        System.out.println("В "+ saveSeconds+" секундах: "+weeks+" Недель, "+days+" Дней, "+hours+" Часов, "+minutes+" Минут, "+seconds+" Секунд");
    }

}
