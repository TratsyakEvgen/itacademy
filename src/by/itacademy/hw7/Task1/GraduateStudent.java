package by.itacademy.hw7.Task1;

public class GraduateStudent extends Learner {
    private boolean scientificWork;

    public void setScientificWork(boolean scientificWork) {
        this.scientificWork = scientificWork;
    }

    public int calculateOfGrants() {
        if (super.getGradePointAverage() >= 5) {
            return 200;
        } else {
            return 180;
        }
    }
}
