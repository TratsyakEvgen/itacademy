package by.itacademy.hw13.task3;

public class Main implements Runnable {
    private final ServiceInteger integer;

    public Main(ServiceInteger integer) {
        this.integer = integer;
    }

    @Override
    public void run() {
        integer.printAndIncremented();
    }

    public static void main(String[] args) {
        ServiceInteger integer = new ServiceInteger(1);
        new Thread(new Main(integer)).start();
        new Thread(new Main(integer)).start();
        new Thread(new Main(integer)).start();
    }


}
