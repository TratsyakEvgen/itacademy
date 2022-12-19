package by.itacademy.hw4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива ");
        int index;
        index = scanner.nextInt();
        if(index > 0) {
            int[] array = new int[index];
            System.out.println("Заполните массив");
            for (int i = 0; i < index; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = scanner.nextInt();
            }
            int max = array[0];
            int min = array[0];
            int indexMax = 0, indexMin = 0;
            for (int i = 0; i < index; i++){
                if (max <= array[i]){
                    max = array[i];
                    indexMax = i;
                }
                if (min >= array[i]){
                    min = array[i];
                    indexMin = i;
                }
            }
            System.out.println("Максимальное значение массива = " + max + " c индексом " + indexMax);
            System.out.println("Минимальное значение массива = " + min + " c индексом " + indexMin);
        } else {
            System.out.println("Длина массива может быть только больше 0");
        }
    }
}
