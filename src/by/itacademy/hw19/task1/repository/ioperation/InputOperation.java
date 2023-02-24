package by.itacademy.hw19.task1.repository.ioperation;

import by.itacademy.hw19.task1.interfaces.Logger;

import java.io.*;

public class InputOperation {
    private final String path;
    private final Logger logger;

    public InputOperation(String path, Logger logger) {
        this.path = path;
        this.logger = logger;
    }

    public Object read() {
        Object object = new Object();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            object = objectInputStream.readObject();
        } catch (SecurityException | IOException | ClassNotFoundException e) {
            logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
        }
        return object;
    }
}
