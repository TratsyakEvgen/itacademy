package by.itacademy.hw18.entity.assemblyLine;

import by.itacademy.hw18.interfaces.IAssemblyLine;
import by.itacademy.hw18.interfaces.IProduct;
import by.itacademy.hw18.interfaces.IProductPart;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


public class AssemblyLine implements IAssemblyLine {
    private final Map<Class<?>, Map<Class<?>, Object>> mapInstructionsOfParts;
    private final Map<Class<?>, Method> mapAssemblyOfParts;

    public AssemblyLine(Map<Class<?>, Map<Class<?>, Object>> mapInstructionsOfParts, Map<Class<?>, Method> mapAssemblyOfParts) {
        this.mapInstructionsOfParts = mapInstructionsOfParts;
        this.mapAssemblyOfParts = mapAssemblyOfParts;
    }

    @Override
    public IProduct assemblyProduct(IProduct product) {
        System.out.println("Поступил запрос на сборку: " + product.getClass());
        mapInstructionsOfParts.forEach((key, mapConstruction) -> {
            System.out.println("Читаем инструкцию по сборке частей и запрашиваем создание: " + key);
            IProductPart productPart = new LineStep(key,
                    mapConstruction.keySet().toArray(new Class[0]),
                    mapConstruction.values().toArray(new Object[0]))
                    .buildProductPart();
            System.out.println("Получаем готовую часть: " + productPart);
            System.out.println("Читаем инструкцию по сборке продукта...");
            Method method = mapAssemblyOfParts.get(productPart.getClass());
            method.setAccessible(true);
            try {
                System.out.println("Устанавливаем " + productPart + " согласно инструкции через метод: " + method);
                method.invoke(product, productPart);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        return product;
    }
}
