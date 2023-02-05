package by.itacademy.hw13.task3;

public class ServiceInteger {
    private Integer integer;

    public ServiceInteger(Integer integer) {
        this.integer = integer;
    }

    public synchronized void printAndIncremented() {
        StringBuilder stringBuilder = new StringBuilder(integer);
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(integer).append(" ");
        }
        System.out.println(stringBuilder);
        integer++;
    }
}
