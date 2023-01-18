package by.itacademy.hw10.task3;

import java.util.*;

public class Stack<J extends Comparable> {

    private final Deque<J> stack = new ArrayDeque<>();

    public Stack() {
    }

    public void push(J item) {
        stack.addLast(item);
    }

    public void pop() {
        if (stack.size() > 0) {
            stack.removeLast();
        }
    }

    public Object max() {
        if (stack.size() > 0) {
            return Collections.max(stack);
        }
        return null;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
