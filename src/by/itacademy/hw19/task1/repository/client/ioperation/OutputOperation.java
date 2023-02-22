package by.itacademy.hw19.task1.repository.client.ioperation;

import by.itacademy.hw19.task1.logger.Logger;

import java.io.*;

public class OutputOperation {
    private final String path;
    private final Logger logger;

    public OutputOperation(String path, Logger logger) {
        this.path = path;
        this.logger = logger;
    }

    public Object write(Object object){
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (SecurityException | IOException e){
            logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
        }
        return object;
    }
}
