package by.itacademy.hw5.Task3;

import java.util.Scanner;

public class Matrix {
    private int numberOfRow;
    private int numberOfColumns;
    private int[][] matrix = new int[numberOfRow][numberOfColumns];

    private Scanner scanner = new Scanner(System.in);

    Matrix() {
    }

    public int getNumberOfRow() {
        return this.numberOfRow;
    }

    public int getNumberOfColumns() {
        return this.numberOfColumns;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public void setNumberOfRow(int numberOfRow) {
        while (numberOfRow <= 0) {
            System.out.print("Количестов строк должно быть больше 0! Повторите ввод: ");
            numberOfRow = scanner.nextInt();
            scanner.nextLine();
        }
        this.numberOfRow = numberOfRow;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        while (numberOfColumns <= 0) {
            System.out.print("Количестов столбцев должно быть больше 0! Повторите ввод: ");
            numberOfColumns = scanner.nextInt();
            scanner.nextLine();
        }
        this.numberOfColumns = numberOfColumns;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public static void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.numberOfRow; i++) {
            for (int j = 0; j < matrix.numberOfColumns; j++) {
                System.out.print(matrix.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Matrix additionMatrices(Matrix firstMatrix, Matrix secondMatrix) {
        Matrix resultMatrix = new Matrix();
        resultMatrix.numberOfRow = firstMatrix.numberOfRow;
        if (firstMatrix.numberOfColumns == secondMatrix.numberOfColumns && firstMatrix.numberOfRow == secondMatrix.numberOfRow) {
            resultMatrix.numberOfRow = firstMatrix.numberOfRow;
            resultMatrix.numberOfColumns = firstMatrix.numberOfColumns;
            resultMatrix.matrix = new int[resultMatrix.numberOfRow][resultMatrix.numberOfColumns];
            for (int i = 0; i < resultMatrix.numberOfRow; i++) {
                for (int j = 0; j < resultMatrix.numberOfColumns; j++) {
                    resultMatrix.matrix[i][j] = firstMatrix.matrix[i][j]+secondMatrix.matrix[i][j];
                }
            }
        } else {
            resultMatrix =null;
            System.out.println("Матрицы имеют разную размерность");
        }
        return resultMatrix;
    }

    public static Matrix multiplyMatrix(Matrix firstMatrix, int number) {
        Matrix resultMatrix = new Matrix();
        resultMatrix.numberOfRow = firstMatrix.numberOfRow;
        resultMatrix.numberOfColumns = firstMatrix.numberOfColumns;
        resultMatrix.matrix = new int[resultMatrix.numberOfRow][resultMatrix.numberOfColumns];
        for (int i = 0; i < resultMatrix.numberOfRow; i++) {
            for (int j = 0; j < resultMatrix.numberOfColumns; j++) {
                resultMatrix.matrix[i][j] = firstMatrix.matrix[i][j]*number;
            }
        }
        return resultMatrix;
    }

    public static Matrix multiplyMatrices(Matrix firstMatrix, Matrix secondMatrix) {
        Matrix resultMatrix = new Matrix();
        if (firstMatrix.numberOfColumns == secondMatrix.numberOfRow) {
            resultMatrix.numberOfRow = firstMatrix.numberOfRow;
            resultMatrix.numberOfColumns = secondMatrix.numberOfColumns;
            resultMatrix.matrix = new int[firstMatrix.numberOfRow][secondMatrix.numberOfColumns];
            for (int i = 0; i < firstMatrix.numberOfRow; i++) {
                for (int j = 0; j < secondMatrix.numberOfColumns; j++) {
                    for (int k = 0; k < secondMatrix.numberOfRow; k++) {
                        resultMatrix.matrix[i][j] += firstMatrix.matrix[i][k] * secondMatrix.matrix[k][j];
                    }
                }
            }
        } else {
            resultMatrix =null;
            System.out.println("Матрицы не могут быть умножены");
        }
        return resultMatrix;
    }

}
