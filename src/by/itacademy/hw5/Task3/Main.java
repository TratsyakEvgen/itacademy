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
        int number;
        number = scanner.nextInt();
        resultMatrix = Matrix.multiplyMatrix(firstMatrix, number);
        Matrix.printMatrix(resultMatrix);

        System.out.println("Умножим матрицы");
        resultMatrix = Matrix.multiplyMatrices(firstMatrix, secondMatrix);
        if (resultMatrix != null) {
            Matrix.printMatrix(resultMatrix);
        }

    }

    private static Matrix creatMatrix() {
        int numberOfRow;
        int numberOfColumns;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        numberOfRow = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        numberOfColumns = scanner.nextInt();

        int[][] array = new int[numberOfRow][numberOfColumns];

        System.out.println("Заполним матрицу случайными числами");
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }

        Matrix matrix = new Matrix();
        matrix.setNumberOfRow(numberOfRow);
        matrix.setNumberOfColumns(numberOfColumns);
        matrix.setMatrix(array);

        return matrix;
    }

}

