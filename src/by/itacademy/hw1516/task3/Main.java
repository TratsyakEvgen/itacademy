package by.itacademy.hw1516.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");

        myList = myList.stream().filter(s -> !s.contains("3"))
                .sorted(Comparator.comparing(s -> s.replaceAll("\\D", "")))
                .sorted((s1, s2) -> {
                    s1 = s1.replaceAll("\\d", "");
                    s2 = s2.replaceAll("\\d", "");
                    return s1.compareTo(s2) * -1;
                })
                .skip(1)
                .collect(Collectors.toList());

        myList = myList.stream().limit(myList.size() - 1)
                .map(s -> s = s.toUpperCase())
                .collect(Collectors.toList());


        myList.stream().forEach(System.out::println); //myList.forEach(System.out::println)

        System.out.println(myList.stream().count()); //System.out.println(myList.size())
    }
}
