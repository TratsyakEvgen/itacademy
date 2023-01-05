package by.itacademy.hw6;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        System.out.println("Введите String:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Double firstNumber = Double.valueOf(string);
        System.out.println(firstNumber);

        System.out.println("Введите double:");
        double valueAsDbl = scanner.nextDouble();
        Double secondNumber = Double.valueOf(valueAsDbl);
        System.out.println(secondNumber);

        System.out.println("Введите integer:");
        int valueAsInteger = scanner.nextInt();
        Double thirdNumber = Double.valueOf(valueAsInteger);
        System.out.println(thirdNumber);

        System.out.println(Double.parseDouble(string));


        Byte valueAsByte = firstNumber.byteValue();
        short valueAsShort = firstNumber.shortValue();
        int valueAsInt = firstNumber.intValue();
        long valueAsLong = firstNumber.longValue();
        char valueAsChar = (char) firstNumber.doubleValue();
        float valueAsFloat = firstNumber.floatValue();
        double valueAsDouble = firstNumber;

        string = "String d = " + Double.toString(3.14);
        System.out.println(string);

    }
}
