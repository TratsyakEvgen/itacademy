package by.itacademy.hw13.task2;

public class ThreadMaxValue extends Thread{
    private final int[] array;
    private int mix;

    public ThreadMaxValue(int[] array) {
        this.array = array;
        this.mix = array[0];
    }

    public int getMax() {
        return mix;
    }
    @Override
    public void run() {
        for (int e : array) {
            if (mix < e) {
                mix = e;
            }
        }
    }
}
