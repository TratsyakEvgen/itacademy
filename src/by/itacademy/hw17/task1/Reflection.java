package by.itacademy.hw17.task1;

import java.util.Arrays;
import java.util.HashMap;

public class Reflection {
    public static void main(String[] args) {
        Class<?> hashMapClass = HashMap.class;

        System.out.println("Поля класса HashMap:");
        Arrays.stream(hashMapClass.getDeclaredFields()).forEach(System.out::println);

        System.out.println("\nКонструкторы класса HashMap:");
        Arrays.stream(hashMapClass.getConstructors()).forEach(System.out::println);

        System.out.println("\nМетоды класса HashMap:");
        Arrays.stream(hashMapClass.getDeclaredMethods()).forEach(System.out::println);

        System.out.println("\nВнутренние классы класса HashMap:");
        Arrays.stream(hashMapClass.getDeclaredClasses()).forEach(System.out::println);
    }
}
