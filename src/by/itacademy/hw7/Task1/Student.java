package by.itacademy.hw7.Task1;

public class Student extends Learner {
    public Student(String firstName, String secondName, int courseNumber, String groupName, double gradePointAverage) {
        super(firstName, secondName, courseNumber, groupName, gradePointAverage);
    }


    @Override
    public int calculateOfGrants() {
        if (this.getGradePointAverage() >= 5) {
            return 100;
        } else {
            return 80;
        }
    }

}
