package by.itacademy.hw7.Task1;

import java.util.Scanner;

public class Learner {
    private String firstName;
    private String secondName;
    private int courseNumber;
    private String groupName;
    private double gradePointAverage;


    public int calculateOfGrants(){
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String string;
        boolean isName= false;
        while (!isName) {
            string = scanner.nextLine();
            isName = isName(string);
            break;
            System.out.print("Введите имя: ");
        }
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    protected boolean isName(String string){
       return string.matches("[А-Я].[а-я]+|[A-Z].[a-z]+");
    }
}
