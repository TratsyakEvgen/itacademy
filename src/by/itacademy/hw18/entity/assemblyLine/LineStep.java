package by.itacademy.hw18.entity.assemblyLine;

import by.itacademy.hw18.interfaces.ILineStep;
import by.itacademy.hw18.interfaces.IProductPart;

import java.lang.reflect.InvocationTargetException;

public class LineStep implements ILineStep {
    private final Class<?> classOfPrat;

    public LineStep(Class<?> classOfPrat) {
        this.classOfPrat = classOfPrat;
    }

    @Override
    public IProductPart buildProductPart() {
        Object object;
        try {
             object = classOfPrat.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return (IProductPart) object;
    }
}
