package by.itacademy.hw12.task1;

public class Main {
    public static void main(String[] args) {

        String path = "src/by/itacademy/hw12/task1/";

        //создаем перый файл с массивом
        ArrayService firstArray = new ArrayService(new int[1000]);
        firstArray.fillRandomly(100000);
        firstArray.writeToFile(path + "in1.txt");

        //создаем второй файл с массивом
        ArrayService secondArray = new ArrayService(new int[1000]);
        secondArray.fillRandomly(100000);
        secondArray.writeToFile(path + "in2.txt");

        //получим данные из первого файла
        firstArray.readFromFile(path + "in1.txt");

        //получим данные из вторго файла
        secondArray.readFromFile(path + "in2.txt");

        //создаем итоговый файл с отсортированым массивом
        firstArray.connectArray(secondArray.getArray());
        firstArray.sortArray();
        firstArray.writeToFile(path + "out.txt");

        //получим данные из итогового файла
        firstArray.readFromFile(path + "out.txt");

    }


}
