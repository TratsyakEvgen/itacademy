package by.itacademy.hw13.task2;

public class ThreadMinValue extends Thread {
    private final int[] array;
    private int min;

    public ThreadMinValue(int[] array) {
        this.array = array;
        this.min = array[0];
    }

    public int getMin() {
        return min;
    }
    @Override
    public void run() {
        for (int e : array) {
            if (min > e) {
                min = e;
            }
        }
    }

}
