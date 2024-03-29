package by.itacademy.hw19.task1.repository.ioperation;

import by.itacademy.hw19.task1.interfaces.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

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
            logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return object;
    }
}
