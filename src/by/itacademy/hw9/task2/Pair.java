package by.itacademy.hw9.task2;

public class Pair<T, J> {
    private Object first;
    private Object second;

    public Pair(T first, J second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return this.first;
    }

    public Object getSecond() {
        return this.second;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    public void invert() {
        Object obj = this.first;
        this.first = this.second;
        this.second = obj;
    }

    @Override
    public String toString() {
        return first + " & " + second;
    }
}
