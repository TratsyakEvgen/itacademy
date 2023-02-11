package by.itacademy.hw14.task3;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Producer implements Runnable {
    private final Semaphore semaphore;
    private final Store store;

    public Producer(Semaphore semaphore, Store store) {
        this.semaphore = semaphore;
        this.store = store;
    }

    @Override
    public void run() {

        int count = 0;
        while (count < 10) {
            try {
                semaphore.acquire();
                int numberOfProducts = store.getNumberOfProducts();
                if (numberOfProducts < Store.getMaxSize()) {
                    store.setNumberOfProducts(++numberOfProducts);
                    System.out.println("Поступил один товар, всего в магазине товаров: "
                            + store.getNumberOfProducts());
                    count++;
                }
                semaphore.release();
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
