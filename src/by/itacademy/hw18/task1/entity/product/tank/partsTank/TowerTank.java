package by.itacademy.hw18.task1.entity.product.tank.partsTank;


import by.itacademy.hw18.task1.interfaces.IProductPart;

public class TowerTank implements IProductPart {
    private final String someParam;

    public TowerTank(String someParam) {
        this.someParam = someParam;
    }

    @Override
    public String toString() {
        return "TowerTank{" +
               "someParam='" + someParam + '\'' +
               '}';
    }
}
