package by.itacademy.hw12;

public class ConsolLogger implements Logger {
    private final Class<?> className;

    public ConsolLogger(Class<?> className) {
        this.className = className;
    }

    @Override
    public Class<?> getClassName() {
        return className;
    }

    @Override
    public void log(String fullMessage) {
        System.out.println(fullMessage);
    }
}
