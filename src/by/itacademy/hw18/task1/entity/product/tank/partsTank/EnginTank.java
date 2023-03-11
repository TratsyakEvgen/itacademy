package by.itacademy.hw18.task1.entity.product.tank.partsTank;


import by.itacademy.hw18.task1.interfaces.IProductPart;

public class EnginTank implements IProductPart {
    private final Integer power;

    public EnginTank(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "EnginTank{" +
               "power=" + power +
               '}';
    }
}
