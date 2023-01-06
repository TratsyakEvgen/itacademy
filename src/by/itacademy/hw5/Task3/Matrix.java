package by.itacademy.hw5.Task3;


public class Matrix {
    private int numberOfRow;
    private int numberOfColumns;
    private int[][] matrix = new int[numberOfRow][numberOfColumns];

    public Matrix() {
    }

    public Matrix(int numberOfRow, int numberOfColumns, int[][] matrix) {
        this.numberOfRow = numberOfRow;
        this.numberOfColumns = numberOfColumns;
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
