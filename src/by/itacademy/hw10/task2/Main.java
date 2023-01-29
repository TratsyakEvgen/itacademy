package by.itacademy.hw10.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\W*\\s+");
        String[] strings = pattern.split(string);

        Map<String, Integer> words = getMap(strings);

        printMap(words);
    }

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> element : map.entrySet()) {
            System.out.println(element.getKey() + " " + element.getValue());
        }
    }

    public static Map<String, Integer> getMap(String[] strings) {
        Map<String, Integer> words = new HashMap<>();
        for (String element : strings) {
            int sum;
            if (words.get(element) == null) {
                sum = 1;
            } else {
                sum = words.get(element) + 1;
            }
            words.put(element, sum);
        }
        return words;
    }
}
