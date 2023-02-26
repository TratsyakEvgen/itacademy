package by.itacademy.hw19.task1.menu.order.action;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.Select;
import by.itacademy.hw19.task1.menu.client.actoin.FindClient;
import by.itacademy.hw19.task1.menu.room.actoin.FindRoom;
import by.itacademy.hw19.task1.menu.room.actoin.SettleClient;
import by.itacademy.hw19.task1.menu.service.actoin.FindService;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.service.RoomService;
import by.itacademy.hw19.task1.util.InputMenuUtil;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

public class NewOrder {

    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Room> rooms;
    private final MapRepository<Client> clients;
    private final MapRepository<Service> services;
    private final MapRepository<Order> orders;

    public NewOrder() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.rooms = MainMenu.getRooms();
        this.services = MainMenu.getServices();
        this.clients = MainMenu.getClients();
        this.orders = MainMenu.getOrders();
    }

    public void show() {
        Optional<Map.Entry<Integer, Room>> optionalRoom = Optional.empty();
        while (optionalRoom.isEmpty()) {
            optionalRoom = new Select<Integer, Room>().show(rooms.read(), new FindRoom());
        }
        Map.Entry<Integer, Room> room = optionalRoom.get();

        Optional<Map.Entry<Integer, Client>> optionalClient = Optional.empty();
        while (optionalClient.isEmpty()) {
            optionalClient = new Select<Integer, Client>().show(clients.read(), new FindClient());
        }
        Map.Entry<Integer, Client> client = optionalClient.get();
        if (!new RoomService().isClientLivedInRoom(room, client)) {
            System.out.println("Клиент не проживает в этом номере!");
            if (!new SettleClient().show(room, optionalClient.get())) {
                return;
            }
        }

        Optional<Map.Entry<Integer, Service>> optionalService = Optional.empty();
        while (optionalService.isEmpty()) {
            optionalService = new Select<Integer, Service>().show(services.read(), new FindService());
        }
        Map.Entry<Integer, Service> service = optionalService.get();

        int numberOfServices = inputMenuUtil.entryValidInt("Количестов: ", 0, 9999);

        LocalDateTime start = inputMenuUtil.entryValidDate("Дата начала: ");

        LocalDateTime end = inputMenuUtil.entryValidDate("Дата окончания: ");

        String description = inputMenuUtil.entryString("Описание: ");

        orders.add(new Order(room, client, service, numberOfServices, start, end, description));
    }
}
