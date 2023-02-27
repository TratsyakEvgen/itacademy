package by.itacademy.hw18.task1.entity.assembly.line;


import by.itacademy.hw18.task1.interfaces.IAssemblyLine;
import by.itacademy.hw18.task1.interfaces.ILineStep;
import by.itacademy.hw18.task1.interfaces.IProduct;
import by.itacademy.hw18.task1.interfaces.IProductPart;

import java.util.Map;


public class AssemblyLine implements IAssemblyLine {
    private final Map<Integer, ILineStep> instruction;

    public AssemblyLine(Map<Integer, ILineStep> instruction) {
        this.instruction = instruction;
    }

    @Override
    public IProduct assemblyProduct(IProduct product) {
        System.out.println("Читаем инструкцию и запрашиваем 1-ю детальку");
        IProductPart firstPart = instruction.get(1).buildProductPart();
        System.out.println("Получаем 1-ю детальку " + firstPart);
        System.out.println("Устанавливаем 1-ю детальку на изделие");
        product.installFirstPart(firstPart);

        System.out.println("Читаем инструкцию и запрашиваем 2-ю детальку");
        IProductPart secondPart = instruction.get(2).buildProductPart();
        System.out.println("Получаем 2-ю детальку " + secondPart);
        System.out.println("Устанавливаем 2-ю детальку на изделие");
        product.installSecondPart(secondPart);

        System.out.println("Читаем инструкцию и запрашиваем 1-ю детальку");
        IProductPart thirdPart = instruction.get(3).buildProductPart();
        System.out.println("Получаем 3-ю детальку " + thirdPart);
        System.out.println("Устанавливаем 3-ю детальку на изделие");
        product.installThirdPart(thirdPart);

        System.out.println("Получаем изделее: " + product);
        return product;
    }
}
