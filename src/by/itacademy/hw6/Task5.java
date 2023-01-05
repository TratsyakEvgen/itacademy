package by.itacademy.hw6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(replace(string,"object-oriented programming"));
    }

    public static StringBuilder replace(String string, String regex){
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        StringBuilder newString = new StringBuilder();
        int count = 0, start = 0;
        while (matcher.find()) {
            if (++count % 2 == 0) {
                int end = matcher.start();
                newString.append(string, start, end).append("OOP");
                start = matcher.end();
            }
        }
        newString.append(string.substring(start));
        return newString;
    }
}
