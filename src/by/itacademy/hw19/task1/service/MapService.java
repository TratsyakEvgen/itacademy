package by.itacademy.hw19.task1.service;

import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.interfaces.Predicate;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapService<K, V> {
    public Map<K, V> map;

    public Logger logger;

    public MapService(Map<K, V> map, Logger logger) {
        this.map = map;
        this.logger = logger;
    }


    public Map<K, V> filterByFieldValue(String fieldName, String value) {
        return filter(fieldName, value, (s, v) -> ((String) s).contains((String) v));
    }

    public Map<K, V> filterByFieldValue(String fieldName, Map.Entry<?, ?> value) {
        return filter(fieldName, value, (m, v) -> ((Map<?, ?>) m)
                .entrySet()
                .stream()
                .anyMatch(entry -> (entry.getKey().equals(((Map.Entry<?, ?>) v).getKey())))
        );
    }

    public <T> Map<K, V> filterByFieldValue(String fieldName, T value) {
        return filter(fieldName, value, Object::equals);
    }

    public Optional<Map.Entry<K, V>> getEntryForKey(Integer key) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getKey(), key))
                .collect(Collectors.toSet())
                .stream()
                .findFirst();
    }

    public Optional<Map.Entry<K, V>> getEntryForValue(V value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .collect(Collectors.toSet())
                .stream()
                .findFirst();
    }

    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((key, value) -> stringBuilder
                .append("id: ")
                .append(key)
                .append("\n")
                .append(value));
        return String.valueOf(stringBuilder);
    }

    private <T> Map<K, V> filter(String fieldName, T value, Predicate predicate) {
        return map.entrySet().stream().filter(entry -> {
            Object object = entry.getValue();
            try {
                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                return predicate.compareValues(field.get(object), value);
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
                logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
            }
            return false;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
