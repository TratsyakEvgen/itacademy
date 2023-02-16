package by.itacademy.hw18.entity.assemblyLine;

import by.itacademy.hw18.interfaces.IProduct;
import by.itacademy.hw18.interfaces.IProductPart;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public  class  InstructionAssembly<T extends IProduct, V extends IProductPart>{
    private final T object;
    private final Class<V>[] arrayParts;

    public InstructionAssembly(T object, Class<V>[] arrayParts) {
        this.object = object;
        this.arrayParts = arrayParts;
    }

    public Map<Method,Class<?>> getInstruction(){
        Map<Method,Class<?>> map = new HashMap<>();
        Method[] methods = object.getClass().getMethods();

        if (methods.length == arrayParts.length){
            for (int i = 0; i < methods.length; i++) {
                map.put(methods[i],arrayParts[i]);
            }
        } else {
            throw new IndexOutOfBoundsException("Неверное количествочастей!");
        }
        return map;
    }

}
