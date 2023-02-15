package by.itacademy.hw17.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(SomeClass.class.getDeclaredMethods()).forEach(method -> {
            System.out.println("Метод: " + method);
            AcademyInfo annotation = method.getAnnotation(AcademyInfo.class);
            System.out.println("Анотация:");
            if (annotation != null) {
                System.out.println(annotation + "\nЗначение поля: " + annotation.year());
            } else {
                System.out.println("Анотация отсутствует");
            }
        });
    }
}
