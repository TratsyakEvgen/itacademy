package by.itacademy.hw11.service.exception;

public class UserNotExistException extends RuntimeException {
    private final String message;

    public UserNotExistException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserNotExistException{" +
                "message='" + message + '\'' +
                '}';
    }
}
