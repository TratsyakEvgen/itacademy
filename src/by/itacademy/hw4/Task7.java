package by.itacademy.hw4;

import java.util.Random;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива ");
        int index;
        index = scanner.nextInt();
        if(index > 0) {
            int[] array = new int[index];

            Random random = new Random();
            for (int i = 0; i < index; i++) {
                array[i] = random.nextInt();
            }
            System.out.println("Массив");
            printArray(array);
            int buffer;
            for (int i = 0, j = index-1; i < j; i++, j--) {
                buffer = array[i];
                array[i] = array[j];
                array[j] = buffer;
            }
            System.out.println("Повернутый массив");
            printArray(array);
        } else {
            System.out.println("Длина массива может быть только больше 0");
        }
    }

    public static void printArray (int[] array){
        for (int element : array){
            System.out.print(" " + element + ";");
        }
        System.out.println();
    }
}
