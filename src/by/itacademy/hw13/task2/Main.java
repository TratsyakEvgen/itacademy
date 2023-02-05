package by.itacademy.hw13.task2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(array));

        ThreadMinValue threadMinValue = new ThreadMinValue(array);
        ThreadMaxValue threadMaxValue = new ThreadMaxValue(array);

        threadMinValue.start();
        threadMaxValue.start();

        try {
            threadMinValue.join();
            threadMaxValue.join();
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        System.out.println("Минимальное значение = " + threadMinValue.getMin());
        System.out.println("Ммаксимальное значение = " + threadMaxValue.getMax());
    }


}
