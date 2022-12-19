package by.itacademy.hw4;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива ");
        int index;
        index = scanner.nextInt();
        if(index > 0) {
            int[] array = new int[index];
            System.out.println("Заполните массив");
            int numberOfNegative = 0;
            int numberOfPositive = 0;
            for (int i = 0; i < index; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = scanner.nextInt();
                if (array[i] < 0){
                    numberOfNegative++;
                } else {
                    numberOfPositive++;
                }
            }
            int[] arrayOfNegative = new int[numberOfNegative];
            int[] arrayOfPositive = new int[numberOfPositive];
            int indexNegative = 0;
            int indexPositive = 0;
            for (int i = 0; i < index; i++){
                if (array[i] < 0) {
                    arrayOfNegative[indexNegative] = array[i];
                    indexNegative++;
                } else {
                    arrayOfPositive[indexPositive] = array[i];
                    indexPositive++;
                }
            }
            System.out.print("Массив отрицацельных чисел:");
            printArray(arrayOfNegative);
            System.out.print("Массив положительных чисел:");
            printArray(arrayOfPositive);
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
