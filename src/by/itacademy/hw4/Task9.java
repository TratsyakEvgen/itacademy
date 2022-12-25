package by.itacademy.hw4;

public class Task9 {
    public static void main(String[] args) {
        int startNumber = 1;
        int endNumber = 999999;
        int numberOfSouvenirs = 0;
        int firstSum;
        int secondSum;
        int numbers;
        for (int i = startNumber; i <= endNumber; i++) {
            numbers = i % 1000;
            secondSum = calculate(numbers);
            numbers = i / 1000;
            firstSum = calculate(numbers);
            if (firstSum == secondSum) {
                numberOfSouvenirs++;
            }
        }
        System.out.println("Трамвайное депо разорится на " + numberOfSouvenirs + " сувенирах...");
    }
    public static int calculate(int numbers){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += numbers % 10;
            numbers /= 10;
        }
        return sum;
    }
}
