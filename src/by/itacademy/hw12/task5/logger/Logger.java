package by.itacademy.hw12.task5.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Logger {


    default void info(String message) {
        getFullMessage("INFO", message);
    }

    default void warm(String message) {
        getFullMessage("WARM", message);
    }

    default void error(String message) {
        getFullMessage("ERROR", message);

    }

    default void getFullMessage(String method, String message){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateNow = LocalDateTime.now().format(formatDate);
        String string = dateNow + " " + method +
                " " + getClassName().getName() +
                " " + message +
                "\n";
        log(string);
    }

    Class<?> getClassName();

    void log(String fullMessage);

}

