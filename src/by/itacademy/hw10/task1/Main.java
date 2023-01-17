package by.itacademy.hw10.task1;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Number> firstSet = new HashSet<>();
        Number firstNumber = 1;
        Number secondNumber = 2;
        Number thirdNumber = 3;

        firstSet.add(firstNumber);
        firstSet.add(secondNumber);
        firstSet.add(thirdNumber);

        System.out.println("Первый набор");
        printSet(firstSet);

        Set<Number> secondSet = new HashSet<>();
        firstNumber = 4;
        secondNumber = 2;
        thirdNumber = 5;


        System.out.println("Второй набор");
        secondSet.add(firstNumber);
        secondSet.add(secondNumber);
        secondSet.add(thirdNumber);

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
