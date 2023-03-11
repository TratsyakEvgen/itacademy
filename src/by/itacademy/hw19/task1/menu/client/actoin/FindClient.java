package by.itacademy.hw19.task1.menu.client.actoin;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.interfaces.IFindMenu;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.service.MapService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindClient implements IFindMenu<Integer, Client> {

    private final Logger logger;
    private final InputValue inputValue;

    public FindClient() {
        this.logger = MainMenu.getLogger();
        this.inputValue = MainMenu.getInputValue();
    }

    @Override
    public void show(Map<Integer, Client> clients) {
        Scanner scanner = new Scanner(System.in);
        MapService<Integer, Client> mapService = new MapService<>(clients, logger);
        clients = new HashMap<>();

        System.out.println("1. Поиск по имени\n" +
                           "2. Поиск по фамилии\n" +
                           "3. Поиск по индификационному номеру\n" +
                           "4. Поиск по возрасту\n" +
                           "5. Поиск по стране\n" +
                           "6. Поиск по номеру телефона\n" +
                           "0. Вернуться назад");

        switch (inputValue.entryValidInt("Выбирете действие: ", 0, 7)) {
            case 1:
                System.out.print("Имя: ");
                clients = mapService.filterByFieldValue("firstName", scanner.nextLine());
                break;
            case 2:
                System.out.print("Фамилия: ");
                clients = mapService.filterByFieldValue("lastName", scanner.nextLine());
                break;
            case 3:
                System.out.print("Номер паспорта: ");
                clients = mapService.filterByFieldValue("identification", scanner.nextLine());
                break;
            case 4:
                clients = mapService.filterByFieldValue("age",
                        inputValue.entryValidInt("Возраст: ", 0, 9999));
                break;
            case 5:
                System.out.print("Страна: ");
                clients = mapService.filterByFieldValue("country", scanner.nextLine());
                break;
            case 6:
                clients = mapService.filterByFieldValue("phoneNumber",
                        inputValue.entryValidString("Номер телефона: ", "\\+{1}[\\d]{12}"));
                break;
            case 0:
                return;
        }
        if (clients.isEmpty()) {
            System.out.println("По вашему запросу ничего не найдено :(");
        } else {
            System.out.println(mapService.getString());
            System.out.println("Продолжим поиск из:");
            show(clients);
        }
    }


}
