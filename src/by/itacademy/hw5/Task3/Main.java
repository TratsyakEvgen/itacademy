package by.itacademy.hw5.Task3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Создадим первую матрицу");
        Matrix firstMatrix = creatMatrix();
        Matrix.printMatrix(firstMatrix);
        System.out.println("Создадим вторую матрицу");
        Matrix secondMatrix = creatMatrix();
        Matrix.printMatrix(secondMatrix);

        System.out.println("Сложим матрицы");
        Matrix resultMatrix = Matrix.additionMatrices(firstMatrix, secondMatrix);
        if (resultMatrix != null) {
            Matrix.printMatrix(resultMatrix);
        }

        System.out.println("Введите число на которое умножим первую матрицу:");
        int number = scanner.nextInt();
        resultMatrix = Matrix.multiplyMatrix(firstMatrix, number);
        Matrix.printMatrix(resultMatrix);

        System.out.println("Умножим матрицы");
        resultMatrix = Matrix.multiplyMatrices(firstMatrix, secondMatrix);
        if (resultMatrix != null) {
            Matrix.printMatrix(resultMatrix);
        }

    }

    private static Matrix creatMatrix() {
        int numberOfRow = enterNumber("Введите количество строк: ");
        int numberOfColumns = enterNumber("Введите количество столбцов: ");

        int[][] array = new int[numberOfRow][numberOfColumns];

        System.out.println("Заполним матрицу случайными числами");
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }

        return new Matrix(numberOfRow,numberOfColumns,array);
    }

    public static int enterNumber(String textMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(textMessage);
        int number = scanner.nextInt();
        while (number < 0) {
            System.out.print("Число не может быть меньше 0! Повторите ввод: ");
            number = scanner.nextInt();
        }
        return number;
    }


}

