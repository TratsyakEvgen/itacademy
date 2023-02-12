package by.itacademy.hw12.task5.hw11.service.exception;

public class WrongLoginException extends RuntimeException {
    private final String message;

    public WrongLoginException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WrongLoginException{" +
                "message='" + message + '\'' +
                '}';
    }
}
