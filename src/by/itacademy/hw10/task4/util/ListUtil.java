package by.itacademy.hw10.task4.util;

import java.util.List;

public class ListUtil {
    public static <T> String listToString(List<T> objects) {
        StringBuilder stringBuilder = new StringBuilder();
        for (T obj : objects) {
            stringBuilder.append(obj.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
