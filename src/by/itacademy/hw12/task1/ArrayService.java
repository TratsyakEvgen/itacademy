package by.itacademy.hw12.task1;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

class ArrayService {
    private int[] array;

    public ArrayService(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void fillRandomly(int bound) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound);
        }
    }

    public void connectArray(int[] secondArray) {
        int[] resultArray = new int[array.length + secondArray.length];
        System.arraycopy(array, 0, resultArray, 0, array.length);
        System.arraycopy(secondArray, 0, resultArray, array.length, secondArray.length);
        array = resultArray;
    }

    public void sortArray() {
        Arrays.sort(array);
    }

    public void readFromFile(String path) {
        try (FileReader fileReader = new FileReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            int charAsInt;
            char chr;
            int i = 0;
            while ((charAsInt = fileReader.read()) != -1) {
                chr = (char) charAsInt;
                if (chr != ' ') {
                    stringBuilder.append(chr);
                } else {
                    array[i] = Integer.parseInt(String.valueOf(stringBuilder));
                    stringBuilder.setLength(0);
                    i++;
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void writeToFile(String path) {
        try (FileWriter fileWriter = new FileWriter(path, false)) {
            for (int i : array) {
                fileWriter.write(i + " ");
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
