package by.itacademy.hw18.entity.product.tank;

import by.itacademy.hw18.interfaces.IProduct;
import by.itacademy.hw18.interfaces.IProductPart;

public class Tank implements IProduct {
    private IProductPart firstPart;
    private IProductPart secondPart;
    private IProductPart thirdPart;


    @Override
    public void installFirstPart(IProductPart firstPart) {
        this.firstPart = firstPart;

    }
    @Override
    public void installSecondPart(IProductPart secondPart) {
        this.secondPart = secondPart;
    }

    @Override
    public void installThirdPart(IProductPart thirdPart) {
        this.thirdPart = thirdPart;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "firstPart=" + firstPart +
                ", secondPart=" + secondPart +
                ", thirdPart=" + thirdPart +
                '}';
    }
}
