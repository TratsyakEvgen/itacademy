package by.itacademy.hw19.task1.menu;

import by.itacademy.hw19.task1.interfaces.IFindMenu;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.service.MapService;
import by.itacademy.hw19.task1.util.InputMenuUtil;

import java.util.Map;
import java.util.Optional;

public class Select<K, V> {

    private final Logger logger;
    private final InputMenuUtil inputMenuUtil;

    public Select() {
        this.logger = MainMenu.getLogger();
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
    }

    public Optional<Map.Entry<K, V>> show(Map<K, V> map, IFindMenu<K, V> menu) {
        Optional<Map.Entry<K, V>> optional = Optional.empty();
        System.out.println("1. Поиск\n" +
                           "2. Ввести id\n" +
                           "0. Вернуться назад");
        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 0, 2)) {
            case 1:
                menu.show(map);
                break;
            case 2:
                int id = inputMenuUtil.entryValidInt("Введите id: ", 1, 2147483647);
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
