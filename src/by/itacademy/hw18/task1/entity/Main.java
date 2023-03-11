package by.itacademy.hw18.task1.entity;

import by.itacademy.hw18.task1.entity.assembly.line.AssemblyLine;
import by.itacademy.hw18.task1.entity.assembly.line.BodyLineStep;
import by.itacademy.hw18.task1.entity.assembly.line.EngineLineStep;
import by.itacademy.hw18.task1.entity.assembly.line.TowerLineStep;
import by.itacademy.hw18.task1.entity.product.tank.Tank;
import by.itacademy.hw18.task1.interfaces.ILineStep;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, ILineStep> instruction = new HashMap<>();
        instruction.put(1, new BodyLineStep());
        instruction.put(2, new EngineLineStep());
        instruction.put(3, new TowerLineStep());
        AssemblyLine assemblyLine = new AssemblyLine(instruction);
        assemblyLine.assemblyProduct(new Tank());
    }
}
