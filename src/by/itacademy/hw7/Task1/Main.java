package by.itacademy.hw7.Task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Learner> learners = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean isEnd = true;
        while (isEnd) {
            learners.add(createLearner());
            System.out.println("Ввести еще одного ученика?  (true/false)");
            isEnd = scanner.nextBoolean();
        }

        for (Learner object : learners) {
            object.getFullInfo(object);
        }
    }


    public static Learner createLearner() {
        String firstName = entryString("Введите имя: ", "[А-Я]{1}[а-я]+|[A-Z]{1}[a-z]+");
        String secondName = entryString("Введите фамилию: ", "[А-Я]{1}[а-я]+|[A-Z]{1}[a-z]+");
        int courseNumber = (int) entryNumber("Номер курса (1-6): ", 1, 6);
        String groupName = entryString("Введите название группы (мин 3 символа): ", "\\w{3,}");
        double gradePointAverage = entryNumber("Введите среднюю оценку (0-10): ", 0, 10);

        Learner learner;
        System.out.print("У ученика есть научная работа? (true/false) :");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextBoolean()) {
            String scientificWork = entryString("Введиде название научной работы: ", "\\.{3,}");
            learner = new GraduateStudent(firstName, secondName, courseNumber, groupName, gradePointAverage, scientificWork);
        } else {
            learner = new Student(firstName, secondName, courseNumber, groupName, gradePointAverage);
        }
        return learner;
    }


    public static String entryString(String textMessage, String regex) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(textMessage);
        String string = scanner.nextLine();
        while (!string.matches(regex)) {
            System.out.print("Неверный формат повторите ввод: ");
            string = scanner.nextLine();
        }
        return string;
    }


    public static double entryNumber(String textMessage, double minValue, double maxValue) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(textMessage);
        double number = scanner.nextDouble();
        scanner.nextLine();
        while (number < minValue || number > maxValue) {
            System.out.print("Неверный формат повторите ввод: ");
            number = scanner.nextDouble();
            scanner.nextLine();
        }
        return number;
    }

}
