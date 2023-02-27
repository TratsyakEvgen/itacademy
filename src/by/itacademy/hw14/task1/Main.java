package by.itacademy.hw14.task1;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Количество секунд = ");
        Thread systemTimer = new Thread(new SystemTimer(scanner.nextInt()));
        systemTimer.setDaemon(true);
        systemTimer.start();

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


}
