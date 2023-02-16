package by.itacademy.hw18.entity;

import by.itacademy.hw18.entity.assemblyLine.AssemblyLine;
import by.itacademy.hw18.entity.product.tank.Tank;
import by.itacademy.hw18.entity.product.tank.partsTank.BodyTank;
import by.itacademy.hw18.entity.product.tank.partsTank.EnginTank;
import by.itacademy.hw18.entity.product.tank.partsTank.TowerTank;
import by.itacademy.hw18.interfaces.IProduct;
import by.itacademy.hw18.interfaces.IProductPart;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Class<?>, Map<Class<?>, Object>> mapInstructionsOfParts = new LinkedHashMap<>();

        Map<Class<?>, Object> mapConstructionBody = new HashMap<>();
        mapConstructionBody.put(String.class, "Литой");
        mapConstructionBody.put(Double.class, 12.9);

        Map<Class<?>, Object> mapConstructionEngine = new HashMap<>();
        mapConstructionEngine.put(String.class, "v12");
        mapConstructionEngine.put(Integer.class, 1300);

        Map<Class<?>, Object> mapConstructionTower = new HashMap<>();
        mapConstructionTower.put(String.class, "Башенка");


        mapInstructionsOfParts.put(BodyTank.class, mapConstructionBody);
        mapInstructionsOfParts.put(EnginTank.class, mapConstructionEngine);
        mapInstructionsOfParts.put(TowerTank.class, mapConstructionTower);


        Map<Class<?>, Method> mapAssemblyOfParts = new HashMap<>();
        try {
            Class<?> tankClass = Tank.class;
            Class<?> iProductClass = IProductPart.class;
            mapAssemblyOfParts.put(BodyTank.class, tankClass.getMethod("installFirstPart", iProductClass));
            mapAssemblyOfParts.put(EnginTank.class, tankClass.getMethod("installSecondPart", iProductClass));
            mapAssemblyOfParts.put(TowerTank.class, tankClass.getMethod("installThirdPart", iProductClass));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        AssemblyLine assemblyLine = new AssemblyLine(mapInstructionsOfParts, mapAssemblyOfParts);
        IProduct product = assemblyLine.assemblyProduct(new Tank());
        System.out.println("Получаем готовое изделее: ");
        System.out.println(product.toString());
    }
}
