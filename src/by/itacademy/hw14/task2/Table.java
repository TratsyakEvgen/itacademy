package by.itacademy.hw14.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        new Thread(new Philosopher(lock, "Аристотель", fork1, fork2)).start();
        new Thread(new Philosopher(lock, "Конфуций", fork2, fork3)).start();
        new Thread(new Philosopher(lock, "Эпикур", fork3, fork4)).start();
        new Thread(new Philosopher(lock, "Платон", fork4, fork5)).start();
        new Thread(new Philosopher(lock, "Зенон", fork5, fork1)).start();


    }
}
