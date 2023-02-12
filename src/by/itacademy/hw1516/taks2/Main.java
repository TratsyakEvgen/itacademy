package by.itacademy.hw1516.taks2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        Collection<Integer> col = Arrays.asList(1, 2, 3, 4, 12, 13, 12, 24, 31, 5, 7);


        System.out.println("Минимальное число = " +
                col.stream().min(Comparator.comparing(Integer::intValue))
                        .orElseThrow(NullPointerException::new));

        System.out.println("Максимально число = " +
                col.stream().max(Comparator.comparing(Integer::intValue))
                        .orElseThrow(NullPointerException::new));

        System.out.println("Среднее арифметическое чисел = " +
                (double) col.stream().mapToInt(n -> n).sum() / col.size());


        System.out.println("Произведение чисел = " +
                (long) col.stream().reduce(1, (a, b) -> a * b));

        System.out.println("Сумма цифр = " +
                col.stream().reduce(0, (a, b) -> {
                    b = Math.abs(b);
                    while (b / 10 != 0 || b % 10 != 0) {
                        a += b % 10;
                        b /= 10;
                    }
                    return a;
                }));
    }
}
