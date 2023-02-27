package by.itacademy.hw19.task1.menu.order.action;

import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.interfaces.IFindMenu;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.service.MapService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindOrder implements IFindMenu<Integer, Order> {

    private final Logger logger;
    private final InputValue inputValue;


    public FindOrder() {
        this.logger = MainMenu.getLogger();
        this.inputValue = MainMenu.getInputValue();
    }

    @Override
    public void show(Map<Integer, Order> orders) {
        Scanner scanner = new Scanner(System.in);
        MapService<Integer, Order> mapService = new MapService<>(orders, logger);
        orders = new HashMap<>();
        System.out.println("1. Поиск по номеру\n" +
                           "2. Поиск по постояльцу\n" +
                           "3. Поиск по услуге\n" +
                           "4. Поиск по количеству\n" +
                           "5. Поиск по статусу\n" +
                           "6. Поиск по дате начала\n" +
                           "7. Поиск по дате окончания\n" +
                           "8. Поиск по описанию\n" +
                           "0. Вернуться назад");

        switch (inputValue.entryValidInt("Выбирете действие: ", 0, 8)) {
            case 1:
                orders = mapService.filterByFieldValue("idRoom",
                        inputValue.entryValidInt("Введите id номера: ", 1, 2147483647));

                break;
            case 2:
                orders = mapService.filterByFieldValue("idClient",
                        inputValue.entryValidInt("Введите id постояльца: ", 1, 2147483647));
                break;
            case 3:
                orders = mapService.filterByFieldValue("idService",
                        inputValue.entryValidInt("Введите id услуги: ", 1, 2147483647));
                break;
            case 4:
                orders = mapService.filterByFieldValue("numberOfServices",
                        inputValue.entryValidInt("Количество: ", 0, 9999));
                break;
            case 5:
                orders = mapService.filterByFieldValue("status",
                        inputValue.entryBoolean("Статус:\n1. Открыт\n2. Закрыт\n"));
                break;
            case 6:
                orders = mapService.filterByFieldValue("start",
                        inputValue.entryValidDate("Дата начала: "));
                break;
            case 7:
                orders = mapService.filterByFieldValue("end",
                        inputValue.entryValidDate("Дата окончания: "));
                break;
            case 8:
                System.out.print("Описание: ");
                orders = mapService.filterByFieldValue("description", scanner.nextLine());
                break;
            case 0:
                return;
        }

        if (orders.isEmpty()) {
            System.out.println("По вашему запросу ничего не найдено :(");
        } else {
            System.out.println(mapService.getString());
            System.out.println("Продолжим поиск из найденых:");
            show(orders);
        }
    }

}
