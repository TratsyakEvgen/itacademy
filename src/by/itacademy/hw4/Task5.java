package by.itacademy.hw4;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива ");
        int index;
        index = scanner.nextInt();
        if(index > 2) {
            int[] array = new int[index];
            System.out.println("Заполните массив");
            for (int i = 0; i < index; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = scanner.nextInt();
            }
            int min = array[1];
            int indexMin = 1;
            for (int i = 1; i < index; i += 2){
                if (min >= array[i]){
                    min = array[i];
                    indexMin = i;
                }
            }
            System.out.println("Минимальное значение массива = " + min + " c нечетным индексом " + indexMin);
        } else {
            System.out.println("Для выполнения данной задачи длина массива может быть только больше 2");
        }
    }
}
