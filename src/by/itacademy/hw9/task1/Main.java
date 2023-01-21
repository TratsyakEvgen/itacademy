package by.itacademy.hw9.task1;

public class Main {
    public static void main(String[] args) {
        Double firstNumber = 3.14;
        Integer secondNumber = 2;
        double result;

        result = Calculator.sum(firstNumber, secondNumber);
        System.out.println(firstNumber + " + " + secondNumber + " = " + result);

        result = Calculator.multiply(firstNumber, secondNumber);
        System.out.println(firstNumber + " * " + secondNumber + " = " + result);

        result = Calculator.divide(firstNumber, secondNumber);
        System.out.println(firstNumber + " / " + secondNumber + " = " + result);

        result = Calculator.subtraction(firstNumber, secondNumber);
        System.out.println(firstNumber + " - " + secondNumber + " = " + result);
    }
}
