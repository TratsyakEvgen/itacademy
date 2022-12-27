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
        for (Learner object: learners) {
            getFullInfo(object);
        }
    }


    public static Learner createLearner() {
        System.out.println("У ученика есть научная работа? (true/false)");
        Scanner scanner = new Scanner(System.in);
        boolean scientificWork = scanner.nextBoolean();
        Learner learner;
        if (scientificWork) {
            GraduateStudent graduateStudent = new GraduateStudent();
            graduateStudent.setScientificWork(true);
            learner = graduateStudent;
        } else {
            learner = new Student();
        }
        setInfoLeaner(learner);
        return learner;
    }

    public static void setInfoLeaner(Learner learner) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        learner.setFirstName(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        learner.setSecondName(scanner.nextLine());
        System.out.print("Номер курса (1-6): ");
        learner.setCourseNumber(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Введите название группы: ");
        learner.setGroupName(scanner.nextLine());
        System.out.print("Введите среднюю оценку: ");
        learner.setGradePointAverage(scanner.nextDouble());
        scanner.nextLine();
    }

    public static void getFullInfo(Learner learner){
        System.out.println("Имя: "+learner.getFirstName());
        System.out.println("Фамилия: "+learner.getSecondName());
        System.out.println("Курс: "+learner.getCourseNumber());
        System.out.println("Группа: "+learner.getGroupName());
        System.out.println("Средняя оценка:  "+learner.getGradePointAverage());
        System.out.println("Стипендия:  "+learner.calculateOfGrants());
        System.out.println();
    }


}
