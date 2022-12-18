package by.itacademy.hw3;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число от 0 до 59 = ");
        int number = scanner.nextInt();
        if (number >= 0 && number <= 59){
            System.out.println(number + " минут это "+getQuarter(number)+" четверть часа");
        } else {
            System.out.println("Число " + number + " не входит в диапазон от 0 до 59");
        }

    }
    public static String getQuarter (int number){
        String quarter="";
        switch (number/15) {
            case 0:
                quarter="первая";
                break;
            case 1:
                quarter="вторая";
                break;
            case 2:
                quarter="третья";
                break;
            case 3:
                quarter="четвертая";
                break;
        }
        return quarter;
    }
}
