package by.itacademy.hw12;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        ConsolLogger consolLogger = new ConsolLogger(Main.class);
        FileLogger fileLogger = new FileLogger(Main.class);
        consolLogger.warm("dgfsdfgd");
        fileLogger.warm("dsgfsdfds");

    }


}
