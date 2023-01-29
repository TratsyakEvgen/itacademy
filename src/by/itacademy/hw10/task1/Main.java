package by.itacademy.hw10.task1;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> firstSet = new HashSet<>();

        firstSet.add(1);
        firstSet.add(2);
        firstSet.add(3);

        System.out.println("Первый набор");
        printSet(firstSet);

        Set<Number> secondSet = new HashSet<>();


        System.out.println("Второй набор");
        secondSet.add(4);
        secondSet.add(2);
        secondSet.add(5);

        printSet(secondSet);

        System.out.println("Объедененый набор");
        printSet(union(firstSet, secondSet));

        System.out.println("Пересеченный набор");
        printSet(intersect(firstSet, secondSet));
    }

    public static void printSet(Set<?> set) {
        for (Object element : set) {
            System.out.println(element);
        }
    }

    public static Set<Object> union(Set<?> set1, Set<?> set2) {
        Set<Object> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Object> intersect(Set<?> set1, Set<?> set2) {
        Set<Object> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
}
