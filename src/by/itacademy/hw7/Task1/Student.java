package by.itacademy.hw7.Task1;

public class Student extends Learner {
    public int calculateOfGrants() {
        if (super.getGradePointAverage() >= 5) {
            return 100;
        } else {
            return 80;
        }
    }

}
