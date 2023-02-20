package by.itacademy.hw18.task1.entity.assembly.line;

import by.itacademy.hw18.task1.interfaces.ILineStep;
import by.itacademy.hw18.task1.interfaces.IProductPart;

import java.lang.reflect.InvocationTargetException;

public class LineStep implements ILineStep {
    private final Class<?> classOfPrat;
    private final Class<?>[] classParams;
    private final Object[] valueParams;

    public LineStep(Class<?> classOfPrat, Class<?>[] classParams, Object[] valueParams) {
        this.classOfPrat = classOfPrat;
        this.classParams = classParams;
        this.valueParams = valueParams;
    }

    @Override
    public IProductPart buildProductPart() {
        Object object;
        try {
            object = classOfPrat.getConstructor(classParams).newInstance(valueParams);
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(object);
        return (IProductPart) object;
    }
}
