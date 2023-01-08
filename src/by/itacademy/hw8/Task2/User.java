package by.itacademy.hw8.Task2;

public class User {
    private final String login;
    private final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public class Query {
        public void printToLog() {
            System.out.printf("Пользователь с логином %s и паролем %s отправил сообщение", login, password);
        }
    }

}
