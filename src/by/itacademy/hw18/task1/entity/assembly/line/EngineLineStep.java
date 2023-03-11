package by.itacademy.hw18.task1.entity.assembly.line;

import by.itacademy.hw18.task1.entity.product.tank.partsTank.EnginTank;
import by.itacademy.hw18.task1.interfaces.ILineStep;
import by.itacademy.hw18.task1.interfaces.IProductPart;

public class EngineLineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        return new EnginTank(1200);
    }
}
