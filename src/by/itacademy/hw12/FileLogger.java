package by.itacademy.hw12;

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
        try{
            FileWriter fileWriter = new FileWriter("Log.txt");
            fileWriter.write(fullMessage);
            fileWriter.close();
        } catch (IOException e){
            e.getStackTrace();
        }


    }

}
