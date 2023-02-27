package by.itacademy.hw19.task1.menu.action;

import by.itacademy.hw19.task1.interfaces.IFindMenu;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.service.MapService;

import java.util.Map;
import java.util.Optional;

public class SelectValue<K, V> {

    private final Logger logger;
    private final InputValue inputValue;

    public SelectValue() {
        this.logger = MainMenu.getLogger();
        this.inputValue = MainMenu.getInputValue();
    }

    public Optional<Map.Entry<K, V>> show(Map<K, V> map, IFindMenu<K, V> menu) {
        Optional<Map.Entry<K, V>> optional = Optional.empty();
        System.out.println("1. Просмотреть список\n" +
                           "2. Ввести id\n" +
                           "0. Вернуться назад");
        switch (inputValue.entryValidInt("Выбирете действие: ", 0, 2)) {
            case 1:
                menu.show(map);
                break;
            case 2:
                int id = inputValue.entryValidInt("Введите id: ", 1, 2147483647);
                optional = new MapService<>(map, logger).get(id);
                if (optional.isEmpty()) {
                    System.out.println("По запросу ничего не найден");
                }
                break;
            case 0:
                break;
        }
        return optional;
    }
}
