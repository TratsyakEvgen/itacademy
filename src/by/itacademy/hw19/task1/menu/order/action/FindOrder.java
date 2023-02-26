package by.itacademy.hw19.task1.menu.order.action;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.interfaces.IFindMenu;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.Select;
import by.itacademy.hw19.task1.menu.client.actoin.FindClient;
import by.itacademy.hw19.task1.menu.room.actoin.FindRoom;
import by.itacademy.hw19.task1.menu.service.actoin.FindService;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.service.MapService;
import by.itacademy.hw19.task1.util.InputMenuUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class FindOrder implements IFindMenu<Integer,Order> {

    private final Logger logger;
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Service> services;
    private final MapRepository<Client> clients;
    private final MapRepository<Room> rooms;

    public FindOrder() {
        this.logger = MainMenu.getLogger();
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.services = MainMenu.getServices();
        this.clients = MainMenu.getClients();
        this.rooms = MainMenu.getRooms();
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

        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 0, 8)) {
            case 1:
                System.out.print("Номер: ");
                Optional<Map.Entry<Integer, Room>> room =
                        new Select<Integer, Room>().show(rooms.read(), new FindRoom());
                if (room.isPresent()) {
                    orders = mapService.filterByFieldValue("room", room.get());
                }
                break;
            case 2:
                System.out.println("Постоялец: ");
                Optional<Map.Entry<Integer, Client>> client =
                        new Select<Integer, Client>().show(clients.read(), new FindClient());
                if (client.isPresent()) {
                    orders = mapService.filterByFieldValue("client", client.get());
                }
                break;
            case 3:
                System.out.println("Услуга: ");
                Optional<Map.Entry<Integer, Service>> service =
                        new Select<Integer, Service>().show(services.read(), new FindService());
                if (service.isPresent()) {
                    orders = mapService.filterByFieldValue("service", service.get());
                }
                break;
            case 4:
                orders = mapService.filterByFieldValue("numberOfServices",
                        inputMenuUtil.entryValidInt("Количество: ", 0, 9999));
                break;
            case 5:
                orders = mapService.filterByFieldValue("status",
                        inputMenuUtil.entryValidBoolean("Статус (true/false): "));
                break;
            case 6:
                orders = mapService.filterByFieldValue("start",
                        inputMenuUtil.entryValidDate("Дата начала: "));
                break;
            case 7:
                orders = mapService.filterByFieldValue("end",
                        inputMenuUtil.entryValidDate("Дата окончания: "));
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
