package by.itacademy.hw12.task5.logger;

import java.io.*;

public class FileLogger implements Logger{

    private final Class<?> className;

    public FileLogger(Class<?> className) {
        this.className = className;
    }

    @Override
    public Class<?> getClassName() {
        return className;
    }

    @Override
    public void log(String fullMessage) {
        try(FileWriter fileWriter = new FileWriter("src/by/itacademy/hw12/task5/Logger/Log.txt", true)){
            fileWriter.write(fullMessage);
        } catch (IOException e){
            e.getStackTrace();
        }


    }

}
