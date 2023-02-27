package by.itacademy.hw18.task1.entity.product.tank.partsTank;


import by.itacademy.hw18.task1.interfaces.IProductPart;

public class BodyTank implements IProductPart {
    private final Double wight;

    public BodyTank(Double wight) {
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "BodyTank{" +
               "wight=" + wight +
               '}';
    }
}
