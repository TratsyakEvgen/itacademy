package by.itacademy.hw14.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class CallableExample implements Callable<String> {
    private final List<Integer> numbers = new ArrayList<>();
    private final int numberThread;

    public CallableExample(int numberThread) {
        this.numberThread = numberThread;
    }

    @Override
    public String call() {
        fillCollection();
        try {
            sleep((long) (1 + Math.random() * 9) * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return "Задача №" + numberThread +
                "; Имя потока: " + Thread.currentThread().getName() +
                "; Результат: " + numbers + " = " + getSumCollection();
    }

    private void fillCollection() {
        for (int i = 0; i < 10; i++) {
            int number = (int) (Math.random() * 10);
            numbers.add(number);
        }
    }

    private int getSumCollection() {
        int sum = 0;
        for (Integer i : numbers) {
            sum += i;
        }
        return sum;
    }

}
