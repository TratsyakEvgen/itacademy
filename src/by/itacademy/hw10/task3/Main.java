package by.itacademy.hw10.task3;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(2);

        System.out.println("Наполним стек:");
        System.out.println(stack);

        System.out.println("Выполним pop");
        stack.pop();
        System.out.println(stack);

        System.out.println("Выполним max:");
        System.out.println(stack.max());
    }
}
