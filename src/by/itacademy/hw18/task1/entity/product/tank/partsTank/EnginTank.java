package by.itacademy.hw18.task1.entity.product.tank.partsTank;


import by.itacademy.hw18.task1.interfaces.IProductPart;

public class EnginTank implements IProductPart {
    private final String model;
    private final Integer power;

    public EnginTank(String model, Integer power) {
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return "EnginTank{" +
                "model='" + model + '\'' +
                ", power=" + power +
                '}';
    }
}
