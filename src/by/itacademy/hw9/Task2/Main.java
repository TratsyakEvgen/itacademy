package by.itacademy.hw9.Task2;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "One");
        System.out.println("Создаем объект <Integer, String> и вернем его значения:");
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());


        Double first = 3.12;
        pair.setFirst(first);
        Boolean second = true;
        pair.setSecond(second);
        System.out.println("Установим новые значения <Double, Boolean>:");
        System.out.println(pair);

        System.out.println("Поменяем местами:");
        pair.invert();
        System.out.println(pair);
    }
}
