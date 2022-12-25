package by.itacademy.hw6;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().trim();

        Pattern pattern = Pattern.compile("\\s+");
        String[] strings = pattern.split(string);

        int indexMaxLength = 0, indexMinLength = 0;
        int maxLength = strings[0].length();
        int minLength = maxLength;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                indexMaxLength = i;
            }
            if (strings[i].length() < minLength) {
                minLength = strings[i].length();
                indexMinLength = i;
            }
        }

        String buffer = strings[indexMinLength];
        strings[indexMinLength] = strings[indexMaxLength];
        strings[indexMaxLength] = buffer;

        System.out.println("Поменяйм местами первое самое длинное слово с последним самым коротким:");
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}
