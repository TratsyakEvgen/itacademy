package by.itacademy.hw19.task1.menu.service.actoin;


import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.interfaces.IFindMenu;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.service.MapService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindService implements IFindMenu<Integer, Service> {
    private final Logger logger;
    private final InputValue inputValue;

    public FindService() {
        this.logger = MainMenu.getLogger();
        this.inputValue = MainMenu.getInputValue();
    }

    @Override
    public void show(Map<Integer, Service> services) {
        Scanner scanner = new Scanner(System.in);
        MapService<Integer, Service> mapService = new MapService<>(services, logger);
        services = new HashMap<>();
        System.out.println("1. Поиск по названию\n" +
                           "2. Поиск по цене\n" +
                           "3. Поиск по описанию\n" +
                           "0. Вернуться назад");

        switch (inputValue.entryValidInt("Выбирете действие: ", 0, 3)) {
            case 1:
                System.out.print("Название: ");
                services = mapService.filterByFieldValue("name", scanner.nextLine());
                break;
            case 2:
                System.out.print("Цена: ");
                services = mapService.filterByFieldValue("price", new BigDecimal(scanner.nextLine()));
                break;
            case 3:
                System.out.print("Описание: ");
                services = mapService.filterByFieldValue("description", scanner.nextLine());
                break;
            case 0:
                return;
        }
        if (services.isEmpty()) {
            System.out.println("По вашему запросу ничего не найдено :(");
        } else {
            System.out.println(mapService.getString());
            System.out.println("Продолжим поиск из найденых:");
            show(services);
        }
    }


}
