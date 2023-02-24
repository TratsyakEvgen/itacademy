package by.itacademy.hw19.task1.logger;

import by.itacademy.hw19.task1.interfaces.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
