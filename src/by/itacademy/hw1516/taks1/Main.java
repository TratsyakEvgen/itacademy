package by.itacademy.hw1516.taks1;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Collection<String> col = Stream.of("Коллекция слов",
                "login is here",
                "что, где, когда?",
                "надо писать дальше",
                "не хватает",
                "фантазии").collect(Collectors.toList());

        System.out.println("Строки которые содержат login:");
        col.stream().filter(s -> s.contains("login")).forEach(System.out::println);

        System.out.println("\nСамая длинная строка: " +
                col.stream().max(Comparator.comparing(String::length))
                        .orElse("Ошибка! Коллекция пустая"));

        System.out.println("\nСамая коротокая строка: " +
                col.stream().min(Comparator.comparing(String::length))
                        .orElse("Ошибка! Коллекция пустая"));

        System.out.println("\nСтроки слова:");
        col.stream().filter(s -> s.matches("[A-Za-zА-Яа-я-]+"))
                .forEach(System.out::println);

        System.out.println("\nВсе уникальные слова:");
        Stream.of(String.join(" ", col)
                        .replaceAll("\\p{Punct}", " ")
                        .split("\\s+"))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

    }

}
