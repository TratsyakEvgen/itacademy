package by.itacademy.hw19.task1.repository.ioperation;

import by.itacademy.hw19.task1.interfaces.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputOperation {
    private final String path;
    private final Logger logger;

    public OutputOperation(String path, Logger logger) {
        this.path = path;
        this.logger = logger;
    }

    public void write(Object object) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (SecurityException | IOException e) {
            logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
        }
    }
}
