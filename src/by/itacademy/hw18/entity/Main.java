package by.itacademy.hw18.entity;

import by.itacademy.hw18.entity.assemblyLine.AssemblyLine;
import by.itacademy.hw18.entity.assemblyLine.InstructionAssembly;
import by.itacademy.hw18.entity.product.tank.Tank;
import by.itacademy.hw18.entity.product.tank.partsTank.BodyTank;
import by.itacademy.hw18.entity.product.tank.partsTank.EnginTank;
import by.itacademy.hw18.entity.product.tank.partsTank.TowerTank;
import by.itacademy.hw18.interfaces.IProduct;
import by.itacademy.hw18.interfaces.IProductPart;

import java.lang.reflect.Method;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Class<? extends IProductPart>[] classes = new Class[]{TowerTank.class, BodyTank.class, EnginTank.class};
        InstructionAssembly<IProduct, IProductPart> instructionAssembly = new InstructionAssembly<>(new Tank(), classes);
        AssemblyLine assemblyLine = new AssemblyLine(instructionAssembly.getInstruction());
        assemblyLine.assemblyProduct(new Tank());
    }
}
