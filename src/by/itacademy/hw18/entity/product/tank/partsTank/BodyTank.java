package by.itacademy.hw18.entity.product.tank.partsTank;

import by.itacademy.hw18.interfaces.IProductPart;

public class BodyTank implements IProductPart {
    private final String type;
    private final Double wight;

    public BodyTank(String type, Double wight) {
        this.type = type;
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "BodyTank{" +
                "type='" + type + '\'' +
                ", wight=" + wight +
                '}';
    }
}
