package by.itacademy.hw14.task3;

import java.util.concurrent.Semaphore;

public class Store {

    private static final int MAX_SIZE = 5;
    private int numberOfProducts;

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public static int getMaxSize() {
        return MAX_SIZE;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Store store = new Store();
        new Thread(new Producer(semaphore, store)).start();
        new Thread(new Consumer(semaphore, store)).start();
    }
}
