package by.itacademy.hw18.entity.assemblyLine;

import by.itacademy.hw18.entity.product.tank.partsTank.TowerTank;
import by.itacademy.hw18.interfaces.IAssemblyLine;
import by.itacademy.hw18.interfaces.IProduct;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;


public class AssemblyLine implements IAssemblyLine {
    private final Map<Method, Class<?>> mapParts;


    public AssemblyLine(Map<Method, Class<?>> mapParts) {
        this.mapParts = mapParts;

    }

    @Override
    public IProduct assemblyProduct(IProduct product) {
        Arrays.stream(product.getClass().getDeclaredMethods()).forEach(method-> {
            method.setAccessible(true);
            try {
                method.invoke(new LineStep(TowerTank.class).buildProductPart());
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        return product;
    }
}
