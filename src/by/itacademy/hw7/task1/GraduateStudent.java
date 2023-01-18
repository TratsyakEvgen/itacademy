package by.itacademy.hw7.task1;

public class GraduateStudent extends Learner {
    private final String scientificWork;

    public GraduateStudent(String firstName, String secondName, int courseNumber,
                           String groupName, double gradePointAverage, String scientificWork) {
        super(firstName, secondName, courseNumber, groupName, gradePointAverage);
        this.scientificWork = scientificWork;
    }

    @Override
    public int calculateOfGrants() {
        if (this.getGradePointAverage() >= 5) {
            return 200;
        } else {
            return 180;
        }
    }
}
