package by.itacademy.hw14.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futureList.add(executor.submit(new CallableExample(i + 1)));
        }

        while (!futureList.isEmpty()) {
            for (int i = 0; i < futureList.size(); i++) {
                Future<String> future = futureList.get(i);
                if (future.isDone()) {
                    try {
                        System.out.println(future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println(e.getMessage());
                    }
                    futureList.remove(i);
                    break;
                }
            }
        }
        executor.shutdown();
    }
}

