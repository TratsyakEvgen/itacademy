package by.itacademy.hw12.task3;

import java.io.*;
import java.util.Random;

public class ArrayService {
    private final byte[] array;

    public ArrayService(byte[] array) {
        this.array = array;
    }

    public byte[] getArray() {
        return array;
    }

    public void fillRandomly(int bound) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) random.nextInt(bound);
        }
    }

    public double getAverage() {
        double total = 0;
        for (byte b : array) {
            total += b;
        }
        return total / array.length;
    }


    public void readFromFile(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int j = fileInputStream.available();
            for (int i = 0; i < j; i++) {
                array[i] = (byte) fileInputStream.read();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void writeToFile(String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, false)) {
            for (int i : array) {
                fileOutputStream.write(i);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
