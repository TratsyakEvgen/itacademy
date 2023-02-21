package by.itacademy.hw19.task1.service.ioservice;

import by.itacademy.hw19.task1.logger.Logger;

import java.io.*;

public class InputService {
    private final String path;
    private final Logger logger;

    public InputService(String path, Logger logger) {
        this.path = path;
        this.logger = logger;
    }

    public Object read(){
        Object object = new Object();
        try (FileInputStream fileInputStream = new FileInputStream(path)){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            object =  objectInputStream.readObject();
        } catch (SecurityException | IOException | ClassNotFoundException e){
            logger.write(e.getMessage());
        }
        return object;
    }

}
