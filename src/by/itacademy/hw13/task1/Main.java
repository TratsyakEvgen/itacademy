package by.itacademy.hw13.task1;


import static java.lang.Thread.sleep;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        FirstThread firstThread = new FirstThread();

        //New
        sleep(1000);
        System.out.println(firstThread.getState());

        //Runnable
        sleep(1000);
        firstThread.start();
        System.out.println(firstThread.getState());

        //Timed_waiting
        sleep(1000);
        System.out.println(firstThread.getState());

        //Waiting
        sleep(1000);
        System.out.println(firstThread.getState());

        //Blocked
        sleep(1000);
        Object object = firstThread.getObject();
        synchronized (firstThread.getObject()) {
            object.notify();
            System.out.println(firstThread.getState());
        }

        //Terminated
        sleep(1000);
        System.out.println(firstThread.getState());

    }
}
