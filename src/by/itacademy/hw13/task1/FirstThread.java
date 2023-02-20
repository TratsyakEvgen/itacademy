package by.itacademy.hw13.task1;


public class FirstThread extends Thread {
    private final Object object = new Object();

    public Object getObject() {
        return object;
    }

    @Override
    public void run() {
        try {
            sleep(1500);
            synchronized (object) {
                object.wait();
            }
        } catch (InterruptedException | IllegalMonitorStateException  e) {
            e.printStackTrace();
        }
    }
}
