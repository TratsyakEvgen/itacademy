package by.itacademy.hw3;

import java.util.Random;

public class Task8 {
    public static void main(String[] args) {
        Random random = new Random();
        int seconds = random.nextInt(28800);
        System.out.println("Петрову отсалосль работать " + seconds + " секунд");
        System.out.println("Сотрудникам осталось работать " + getHours(seconds));
    }
    public static String getHours(int seconds){
        int hours = seconds/3600;
        String timeInHours;
        switch (hours) {
            case 0:
                timeInHours = "меньше часа";
                break;
            case 1:
                timeInHours = hours + " час";
                break;
            case 2:
            case 3:
            case 4:
                timeInHours = hours + " часa";
                break;
            default:
                timeInHours = hours + " часов";
                break;
        }
        return timeInHours;
    }
}
