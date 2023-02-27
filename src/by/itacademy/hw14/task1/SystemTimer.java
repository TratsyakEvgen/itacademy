package by.itacademy.hw14.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Thread.sleep;


public class SystemTimer implements Runnable {

    private final int seconds;

    public SystemTimer(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        while (true) {
            LocalDateTime dateTime = LocalDateTime.now();
            System.out.println(dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            try {
                sleep(seconds * 1000L);
            } catch (InterruptedException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
