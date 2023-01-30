package by.itacademy.hw8.task2;


public class Main {
    public static void main(String[] args) {
        User user = new User("User", "Password");
        User.Query query = user.new Query();
        query.printToLog();
    }
}
