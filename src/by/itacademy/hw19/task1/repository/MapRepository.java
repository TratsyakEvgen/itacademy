package by.itacademy.hw19.task1.repository;

import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.repository.ioperation.InputOperation;
import by.itacademy.hw19.task1.repository.ioperation.OutputOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapRepository<V> {
    private final String path;
    private final Logger logger;

    public MapRepository(String path, Logger logger) {
        this.path = path;
        this.logger = logger;
    }

    public Map<Integer, V> read() {
        InputOperation inputOperation = new InputOperation(path, logger);
        Object object = inputOperation.read();
        if (object instanceof Map) {
            return (Map<Integer, V>) inputOperation.read();
        }
        return new HashMap<>();
    }

    public void add(V value) {
        Map<Integer, V> map = read();
        Integer id = map.keySet().stream().max(Integer::compare).orElse(0);
        map.put(id + 1, value);
        write(map);
    }

    public void remove(Integer id) {
        Map<Integer, V> map = read();
        map.remove(id);
        write(map);
    }

    public void update(Integer key, V value) {
        Map<Integer, V> map = read();
        map.replace(key, value);
        write(map);
    }

    public Optional<Map.Entry<Integer, V>> get(Integer key) {
        return read().entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getKey(), key))
                .collect(Collectors.toSet())
                .stream()
                .findFirst();
    }

    private void write(Map<Integer, V> map) {
        OutputOperation outputOperation = new OutputOperation(path, logger);
        outputOperation.write(map);
    }

}
