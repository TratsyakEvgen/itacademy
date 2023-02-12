package by.itacademy.hw12.task2;

public class Main {
    public static void main(String[] args) {
        String string = "Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.";
        String path = "src/by/itacademy/hw12/task2/Text.txt";

        StringService writableString = new StringService(string);
        writableString.writeToFile(path);

        StringService readableString = new StringService();
        readableString.readFromFile(path);
        System.out.println(readableString.getString());
        System.out.println("Количество знаков припинания = " + readableString.getNumberOfPunctuationMarks());
        System.out.println("Количество слов = " + readableString.getNumberOfWords());
    }

}
