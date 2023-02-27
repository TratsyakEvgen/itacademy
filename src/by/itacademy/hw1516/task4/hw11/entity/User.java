package by.itacademy.hw1516.task4.hw11.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    private final String login;
    private final String password;
    private final LocalDateTime registrationDate;
    private LocalDateTime lastAuthorizationDate;

    public User(String login, String password, LocalDateTime registrationDate) {
        this.login = login;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }


    public void setLastAuthorizationDate(LocalDateTime lastAuthorizationDate) {
        this.lastAuthorizationDate = lastAuthorizationDate;
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' +
                ", registrationDate=" +
                dateFormat(registrationDate) +
                ", lastAuthorizationDate=" +
                dateFormat(lastAuthorizationDate);
    }


    private String dateFormat(LocalDateTime localDateTime) {
        String string = null;
        if (localDateTime != null) {
            string = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy"));
        }
        return string;
    }
}
