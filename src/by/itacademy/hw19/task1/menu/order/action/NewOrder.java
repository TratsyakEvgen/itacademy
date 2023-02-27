package by.itacademy.hw19.task1.menu.order.action;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.menu.action.SelectValue;
import by.itacademy.hw19.task1.menu.client.actoin.FindClient;
import by.itacademy.hw19.task1.menu.room.actoin.FindRoom;
import by.itacademy.hw19.task1.menu.room.actoin.SettleClient;
import by.itacademy.hw19.task1.menu.service.actoin.FindService;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.service.RoomService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NewOrder {

    private final InputValue inputValue;
    private final MapRepository<Room> rooms;
    private final MapRepository<Client> clients;
    private final MapRepository<Order> orders;

    public NewOrder() {
        this.inputValue = MainMenu.getInputValue();
        this.rooms = MainMenu.getRooms();
        this.clients = MainMenu.getClients();
        this.orders = MainMenu.getOrders();
    }

    public void show() {
        System.out.println("Номер (обязательно для заполнения):");
        Optional<Map.Entry<Integer, Room>> optionalRoom = Optional.empty();
        while (optionalRoom.isEmpty()) {
            optionalRoom = new SelectValue<Integer, Room>().show(rooms.read(), new FindRoom());
            if (optionalRoom.isEmpty()) {
                if (!inputValue.entryBoolean("Номер не выбран! \nПовторить?\n1. Да\n2. Нет\n")) {
                    return;
                }
            }
        }
        Map.Entry<Integer, Room> room = optionalRoom.get();
        Map<Integer, Room> roomMap = new HashMap<>();
        roomMap.put(room.getKey(), room.getValue());

        System.out.println("Постоялец (обязательно для заполнения):");
        Optional<Map.Entry<Integer, Client>> optionalClient = Optional.empty();
        while (optionalClient.isEmpty()) {
            optionalClient = new SelectValue<Integer, Client>().show(clients.read(), new FindClient());
            if (optionalClient.isEmpty()) {
                if (!inputValue.entryBoolean("Клиент не выбран! \nПовторить?\n1. Да\n2. Нет\n")) {
                    return;
                }
            }
        }
        Map.Entry<Integer, Client> client = optionalClient.get();
        Map<Integer, Client> clientMap = new HashMap<>();
        clientMap.put(client.getKey(), client.getValue());
        if (!new RoomService().isClientLivedInRoom(room, client)) {
            System.out.println("Клиент не проживает в этом номере!");
            if (!new SettleClient().show(room, optionalClient.get())) {
                System.out.println("Регистрация заказа прервана!");
                return;
            }
        }

        System.out.println("Услуга номера (обязательно для заполнения): ");
        Optional<Map.Entry<Integer, Service>> optionalService = Optional.empty();
        while (optionalService.isEmpty()) {
            optionalService = new SelectValue<Integer, Service>().show(optionalRoom
                            .get()
                            .getValue()
                            .getServices(),
                    new FindService());
            if (optionalService.isEmpty()) {
                if (!inputValue.entryBoolean("Услуга не выбрана! \nПовторить?\n1. Да\n2. Нет\n")) {
                    return;
                }
            }
        }
        Map.Entry<Integer, Service> service = optionalService.get();
        Map<Integer, Service> serviceMap = new HashMap<>();
        serviceMap.put(service.getKey(), service.getValue());

        int numberOfServices = inputValue.entryValidInt("Количестов (обязательно для заполнения): ",
                0, 9999);

        LocalDateTime start = inputValue.entryValidDate("Дата начала yyyy-MM-dd HH:mm(обязательно для заполнения): ");

        LocalDateTime end = inputValue.entryValidDate("Дата окончания yyyy-MM-dd HH:mm(обязательно для заполнения): ");

        String description = inputValue.entryString("Описание: ");

        orders.add(new Order(roomMap, clientMap, serviceMap, numberOfServices, start, end, description));
    }
}
