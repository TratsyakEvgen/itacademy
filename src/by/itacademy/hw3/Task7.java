package by.itacademy.hw3;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа:");
        System.out.print("Число а = ");
        int a = scanner.nextInt();
        System.out.print("число b = ");
        int b = scanner.nextInt();
        System.out.print("Каков результат умножения первого числа на второе?");
        int result = scanner.nextInt();
        if (result==a*b){
            System.out.print("Верно!");
        } else {
            System.out.print("Вы ошиблись. Правельный ответ "+a*b);
        }
    }
}
