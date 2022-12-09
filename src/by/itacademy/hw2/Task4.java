package by.itacademy.hw2;

public class Task4 {
    public static void main(String[] args) {
        byte valueAsByte = 100;
        short valueAsShort = 200;
        int valueAsInt = 321;
        long valueAsLong = 345324L;
        char valueAsChar = 'g';
        float valueAsFloat = 2.3f;
        double valueAsDouble = 3.4;

        convertByte(valueAsByte);
        convertShort(valueAsShort);
        convertInt(valueAsInt);
        convertLong(valueAsLong);
        convertChar(valueAsChar);
        convertFloat(valueAsFloat);
        convertDouble(valueAsDouble);
    }
    public static void convertByte(byte valueAsByte){
        short valueAsShort = valueAsByte;
        int valueAsInt = valueAsByte;
        long valueAsLong = valueAsByte;
        char valueAsChar = (char) valueAsByte;
        float valueAsFloat = valueAsByte;
        double valueAsDouble = valueAsByte;
        System.out.println("Число "+valueAsByte+" типа byte после преобразования в тип:");
        System.out.println("short = "+valueAsShort);
        System.out.println("int = "+valueAsInt);
        System.out.println("long = "+valueAsLong);
        System.out.println("char = "+valueAsChar);
        System.out.println("float = "+valueAsFloat);
        System.out.println("double = "+valueAsDouble);
    }
    public static void convertShort(short valueAsShort){
        byte valueAsByte = (byte) valueAsShort;
        int valueAsInt = valueAsShort;
        long valueAsLong = valueAsShort;
        char valueAsChar = (char) valueAsShort;
        float valueAsFloat = valueAsShort;
        double valueAsDouble = valueAsShort;
        System.out.println("Число "+valueAsShort+" типа short после преобразования в тип:");
        System.out.println("byte = "+valueAsByte);
        System.out.println("int = "+valueAsInt);
        System.out.println("long = "+valueAsLong);
        System.out.println("char = "+valueAsChar);
        System.out.println("float = "+valueAsFloat);
        System.out.println("double = "+valueAsDouble);
    }
    public static void convertInt(int valueAsInt){
        byte valueAsByte = (byte) valueAsInt;
        short valueAsShort = (short) valueAsInt;
        long valueAsLong = valueAsInt;
        char valueAsChar = (char) valueAsInt;
        float valueAsFloat = (float) valueAsInt;
        double valueAsDouble = valueAsInt;
        System.out.println("Число "+valueAsInt+" типа int после преобразования в тип:");
        System.out.println("byte = "+valueAsByte);
        System.out.println("short = "+valueAsShort);
        System.out.println("long = "+valueAsLong);
        System.out.println("char = "+valueAsChar);
        System.out.println("float = "+valueAsFloat);
        System.out.println("double = "+valueAsDouble);
    }
    public static void convertLong(long valueAsLong){
        byte valueAsByte = (byte) valueAsLong;
        short valueAsShort = (short) valueAsLong;
        int valueAsInt = (int) valueAsLong;
        char valueAsChar = (char) valueAsLong;
        float valueAsFloat = (float) valueAsLong;
        double valueAsDouble = (double) valueAsLong;
        System.out.println("Число "+valueAsLong+" типа long после преобразования в тип:");
        System.out.println("byte = "+valueAsByte);
        System.out.println("short = "+valueAsShort);
        System.out.println("int = "+valueAsInt);
        System.out.println("char = "+valueAsChar);
        System.out.println("float = "+valueAsFloat);
        System.out.println("double = "+valueAsDouble);
    }
    public static void convertChar(char valueAsChar){
        byte valueAsByte = (byte) valueAsChar;
        short valueAsShort = (short) valueAsChar;
        int valueAsInt = valueAsChar;
        long valueAsLong = valueAsChar;
        float valueAsFloat = valueAsChar;
        double valueAsDouble = valueAsChar;
        System.out.println("значение "+valueAsChar+" типа char после преобразования в тип:");
        System.out.println("byte = "+valueAsByte);
        System.out.println("short = "+valueAsShort);
        System.out.println("int = "+valueAsInt);
        System.out.println("long = "+valueAsLong);
        System.out.println("float = "+valueAsFloat);
        System.out.println("double = "+valueAsDouble);
    }
    public static void convertFloat(float valueAsFloat){
        byte valueAsByte = (byte) valueAsFloat;
        short valueAsShort = (short) valueAsFloat;
        int valueAsInt = (int) valueAsFloat;
        long valueAsLong = (long) valueAsFloat;
        char valueAsChar = (char) valueAsFloat;
        double valueAsDouble = valueAsFloat;
        System.out.println("Число "+valueAsFloat+" типа float после преобразования в тип:");
        System.out.println("byte = "+valueAsByte);
        System.out.println("short = "+valueAsShort);
        System.out.println("int = "+valueAsInt);
        System.out.println("long = "+valueAsLong);
        System.out.println("char = "+valueAsChar);
        System.out.println("double = "+valueAsDouble);
    }
    public static void convertDouble(double valueAsDouble){
        byte valueAsByte = (byte) valueAsDouble;
        short valueAsShort = (short) valueAsDouble;
        int valueAsInt = (int) valueAsDouble;
        long valueAsLong = (long) valueAsDouble;
        char valueAsChar = (char) valueAsDouble;
        float valueAsFloat = (float) valueAsDouble;
        System.out.println("Число "+valueAsDouble+" типа double после преобразования в тип:");
        System.out.println("byte = "+valueAsByte);
        System.out.println("short = "+valueAsShort);
        System.out.println("int = "+valueAsInt);
        System.out.println("long = "+valueAsLong);
        System.out.println("char = "+valueAsChar);
        System.out.println("float = "+valueAsFloat);
    }
}
