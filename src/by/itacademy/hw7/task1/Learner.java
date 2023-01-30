package by.itacademy.hw7.task1;


public abstract class Learner {
    private final String firstName;
    private final String secondName;
    private final int courseNumber;
    private final String groupName;
    private final double gradePointAverage;

    public Learner(String firstName, String secondName, int courseNumber, String groupName, double gradePointAverage) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.courseNumber = courseNumber;
        this.groupName = groupName;
        this.gradePointAverage = gradePointAverage;
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    protected abstract int calculateOfGrants();

    protected void getFullInfo(Learner learner) {
        System.out.println("Имя: " + learner.firstName);
        System.out.println("Фамилия: " + learner.secondName);
        System.out.println("Курс: " + learner.courseNumber);
        System.out.println("Группа: " + learner.groupName);
        System.out.println("Средняя оценка:  " + learner.gradePointAverage);
        System.out.println("Стипендия:  " + learner.calculateOfGrants());
        System.out.println();
    }
}
