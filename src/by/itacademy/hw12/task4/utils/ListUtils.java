package by.itacademy.hw12.task4.utils;

import java.util.List;

public class ListUtils {
    public static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }
}
