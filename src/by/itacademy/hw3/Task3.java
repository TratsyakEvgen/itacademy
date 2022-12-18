package by.itacademy.hw3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число от 1 до 7 = ");
        int number = scanner.nextInt();
        if (number > 0 && number < 8){
            System.out.println("Число " + number + " как день в неделе это "+getDay(number));
        } else {
            System.out.println("Число " + number + " не входит в диапазон от 1 до 7");
        }

}
    public static String getDay (int number){
        String day;
        switch (number) {
        case 1:
            day="понедельник";
            break;
        case 2:
            day="вторник";
            break;
        case 3:
            day="среда";
            break;
        case 4:
            day="четверг";
            break;
        case 5:
            day="пятница";
            break;
        default:
            day="выходной";
            break;
    }
        return day;
    }
}
