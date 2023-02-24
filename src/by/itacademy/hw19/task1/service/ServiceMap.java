package by.itacademy.hw19.task1.service;

import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.interfaces.Predicate;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceMap<V, K> {
    private final Map<V, K> map;

    private final Logger logger;

    public ServiceMap(Map<V, K> map, Logger logger) {
        this.map = map;
        this.logger = logger;
    }

    public Map<V, K> filterByFieldValue(String fieldName, String value) {
        return filter(fieldName, value, (s, v) -> ((String) s).contains((String) v));
    }

    public <T> Map<V, K> filterByFieldValue(String fieldName, T value) {
        return filter(fieldName, value, Object::equals);
    }

    private  <T> Map<V, K> filter(String fieldName, T value, Predicate predicate) {
        return map.entrySet().stream().filter(entry -> {
            Object client = entry.getValue();
            try {
                Field field = client.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                return predicate.compareValues(field.get(client), value);
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
                logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
            }
            return false;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
