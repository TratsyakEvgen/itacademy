package by.itacademy.hw18.task1.entity.assembly.line;

import by.itacademy.hw18.task1.entity.product.tank.partsTank.TowerTank;
import by.itacademy.hw18.task1.interfaces.ILineStep;
import by.itacademy.hw18.task1.interfaces.IProductPart;

public class TowerLineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        return new TowerTank("башня");
    }
}
