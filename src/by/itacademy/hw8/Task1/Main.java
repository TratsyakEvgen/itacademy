package by.itacademy.hw8.Task1;

public class Main {
    public static void main(String[] args) {
        Cookable cookable = new Cookable() {
            @Override
            public void cook(String str) {
                System.out.println(str);
            }
        };
        Food food = new Food();
        food.prepare(cookable,"Готовим!");
    }
}
