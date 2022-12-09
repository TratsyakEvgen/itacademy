package by.itacademy.hw2;
public class Task2 {
    public static void main(String[] args) {
        int firstNumber = 2;
        int secondNumber = 3;
        int result = calculation(firstNumber, secondNumber);
        System.out.println(result);
    }
    public static int calculation(int firstNumber, int secondNumber){
        int result = firstNumber + secondNumber;
        result += firstNumber * secondNumber;
        return result;
    }
}
