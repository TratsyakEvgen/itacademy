package by.itacademy.hw12.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String path = "src/by/itacademy/hw12/task3/Array.data";

        ArrayService array = new ArrayService(new byte[30]);
        array.fillRandomly(100);
        array.writeToFile(path);


        array.readFromFile(path);
        System.out.println(Arrays.toString(array.getArray()));
        System.out.println("Среднее арифметическое = " + array.getAverage());

    }
}
