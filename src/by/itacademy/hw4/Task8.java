package by.itacademy.hw4;

import java.util.Random;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива ");
        int index;
        index = scanner.nextInt();
        if(index > 0) {
            int[] array1 = new int[index];
            fillArray(array1);
            int[] array2 = array1.clone();
            int[] array3 = array1.clone();

            System.out.println("Исходный массив");
            printArray(array1);
            sortBubble(array1);
            System.out.println("Сортировка пузырьком: ");
            printArray(array1);

            sortInsertion(array2);
            System.out.println("Сортировка вставками: ");
            printArray(array2);

            sortSelection(array3);
            System.out.println("Сортировка выборкой: ");
            printArray(array3);
        } else {
            System.out.println("Длина массива может быть только больше 0");
        }
    }


    public static void fillArray(int[] array){
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // для наглядности ограничим
        }
    }

    public static void printArray (int[] array){
        for (int element : array){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void sortBubble(int[] array){
        int buffer;
        for (int i = 0; i < array.length-1; ++i){
            for (int j = 0; j < array.length-i-1; ++j){
                if (array[j+1] < array[j]){
                    buffer = array[j];
                    array[j] = array[j+1];
                    array[j+1] = buffer;
                }
            }
        }
    }

    public static void sortInsertion(int [] array){
        int buffer;
        for(int i = 0; i < array.length; ++i){
            int j = i;
            while(j > 0 && array[j-1] > array[j]){
                buffer = array[j];
                array[j] = array[j-1];
                array[j-1] = buffer;
                j = j-1;
            }
        }
    }

    public static void sortSelection(int [] array){
        int min, position;
        for(int i = 0; i < array.length; i++){
            min = array[i];
            position = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min){
                    min = array[j];
                    position = j;
                }
            }
            array[position] = array[i];
            array[i] = min;
        }
    }


}
