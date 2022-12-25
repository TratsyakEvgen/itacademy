package by.itacademy.hw4;

import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк массива ");
        int indexRows;
        indexRows = scanner.nextInt();
        System.out.print("Введите длину массива ");
        int indexColumns;
        indexColumns = scanner.nextInt();
        if(indexRows > 0 && indexColumns >0) {
            System.out.println("Заполним массив случайными числами...");
            int[][] array = new int[indexRows][indexColumns];
            array = fillArray(array);
            System.out.println("Выводим на печать полученный массив:");
            printArray(array);
            long maxSumline; //на случай переполнения integer;
            long sumline;
            maxSumline = array[0][0];
            for (int i = 0; i < array.length; i++) {
                sumline = 0L;
                for (int j = 0; j < array[0].length; j++) {
                    sumline += array[i][j];
                }
                if (sumline > maxSumline){
                    maxSumline = sumline;
                    indexRows = i;
                }
            }

            System.out.println("Максимальна сумма строки = " + maxSumline + " с индексом  = "
                    + indexRows + " (" + (indexRows + 1) + " строка матрицы)");
        } else {
            System.out.println("Неверно задана размерность массива");
        }
    }
        public static void printArray (int[][] array){
            for (int[] ints : array) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.println();
            }
        }

        public static int[][] fillArray(int[][] array){
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = random.nextInt(100);
                }
            }
        return array;
        }

}
