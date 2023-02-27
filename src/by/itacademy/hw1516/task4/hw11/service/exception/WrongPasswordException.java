package by.itacademy.hw1516.task4.hw11.service.exception;

public class WrongPasswordException extends RuntimeException {
    private final String message;

    public WrongPasswordException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WrongPasswordException{" +
                "message='" + message + '\'' +
                '}';
    }
}
