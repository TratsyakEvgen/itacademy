package by.itacademy.hw9.Task1;

public class Calculator {
    public static <T extends Number> double sum(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() + secondNumber.doubleValue();
    }

    public static <T extends Number> double multiply(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() * secondNumber.doubleValue();
    }

    public static <T extends Number> double divide(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() / secondNumber.doubleValue();
    }

    public static <T extends Number> double subtraction(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() - secondNumber.doubleValue();
    }
}
