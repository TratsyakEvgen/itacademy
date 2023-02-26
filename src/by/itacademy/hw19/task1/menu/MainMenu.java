package by.itacademy.hw19.task1.menu;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.menu.client.ClientMenu;
import by.itacademy.hw19.task1.menu.order.OrderMenu;
import by.itacademy.hw19.task1.menu.room.RoomMenu;
import by.itacademy.hw19.task1.menu.service.ServiceMenu;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;


public class MainMenu {

    private static Logger logger;
    private static InputMenuUtil inputMenuUtil;
    private static MapRepository<Client> clients;
    private static MapRepository<Service> services;
    private static MapRepository<Room> rooms;
    private static MapRepository<Order> orders;

    public MainMenu(Logger logger,
                    InputMenuUtil inputMenuUtil,
                    MapRepository<Client> clients,
                    MapRepository<Service> services,
                    MapRepository<Room> rooms,
                    MapRepository<Order> orders) {
        MainMenu.logger = logger;
        MainMenu.inputMenuUtil = inputMenuUtil;
        MainMenu.clients = clients;
        MainMenu.services = services;
        MainMenu.rooms = rooms;
        MainMenu.orders = orders;
    }


    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        MainMenu mainMenu = new MainMenu(logger,
                new InputMenuUtil(logger),
                new MapRepository<>("src/by/itacademy/hw19/task1/data/clients.data", logger),
                new MapRepository<>("src/by/itacademy/hw19/task1/data/services.data", logger),
                new MapRepository<>("src/by/itacademy/hw19/task1/data/rooms.data", logger),
                new MapRepository<>("src/by/itacademy/hw19/task1/data/orders.data", logger));
        mainMenu.show();
    }


    public void show() {
        System.out.println("1. Клиенты\n" +
                           "2. Номера\n" +
                           "3. Сервисы\n" +
                           "4. Заказы\n" +
                           "0. Выход");
        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 0, 4)) {
            case 1:
                new ClientMenu().show();
                show();
                break;
            case 2:
                new RoomMenu().show();
                show();
                break;
            case 3:
                new ServiceMenu().show();
                show();
                break;
            case 4:
                new OrderMenu().show();
                show();
                break;
            case 0:
                break;
        }
    }

    public static Logger getLogger() {
        return logger;
    }

    public static InputMenuUtil getInputMenuUtil() {
        return inputMenuUtil;
    }

    public static MapRepository<Client> getClients() {
        return clients;
    }

    public static MapRepository<Service> getServices() {
        return services;
    }

    public static MapRepository<Room> getRooms() {
        return rooms;
    }

    public static MapRepository<Order> getOrders() {
        return orders;
    }
}
