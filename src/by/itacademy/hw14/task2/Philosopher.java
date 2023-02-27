package by.itacademy.hw14.task2;

import java.util.concurrent.locks.Lock;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {
    private final Lock lock;
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(Lock lock, String name, Fork leftFork, Fork rightFork) {
        this.lock = lock;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        boolean isAte = false;
        while (!isAte) {
            if (pickUpForks()) {
                isAte = true;
            } else {
                System.out.println("Философ " + name + " размышляет");
                sendSleep();
            }

        }

    }

    private boolean pickUpForks() {
        if (lock.tryLock()) {
            System.out.printf("%s ест вилками №%d и №%d%n",
                    name, leftFork.getNumber(), rightFork.getNumber());
            sendSleep();
            lock.unlock();
            return true;
        } else {
            return false;
        }
    }

    private void sendSleep() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
