package by.itacademy.hw12.task2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringService {
    private String string;

    public StringService(String string) {
        this.string = string;
    }

    public StringService() {
    }

    public String getString() {
        return string;
    }

    public int getNumberOfPunctuationMarks() {
        return getNumberForMatches("\\p{Punct}");
    }

    public int getNumberOfWords() {
        return getNumberForMatches("[A-Za-z0-9А-Яа-я\\p{Punct}]+");
    }

    public int getNumberForMatches(String regex) {
        int numberOfMarks = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            numberOfMarks++;
        }
        return numberOfMarks;
    }

    public void readFromFile(String path) {
        try (FileReader fileReader = new FileReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            int chr;
            while ((chr = fileReader.read()) != -1) {
                stringBuilder.append((char) chr);
            }
            string = String.valueOf(stringBuilder);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void writeToFile(String path) {
        try (FileWriter fileWriter = new FileWriter(path, false)) {
            fileWriter.write(string);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
