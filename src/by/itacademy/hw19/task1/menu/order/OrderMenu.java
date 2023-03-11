package by.itacademy.hw19.task1.menu.order;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.menu.action.SelectValue;
import by.itacademy.hw19.task1.menu.client.actoin.FindClient;
import by.itacademy.hw19.task1.menu.order.action.FindOrder;
import by.itacademy.hw19.task1.menu.order.action.NewOrder;
import by.itacademy.hw19.task1.menu.room.actoin.FindRoom;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.service.MapService;
import by.itacademy.hw19.task1.service.OrderService;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class OrderMenu {

    private final Logger logger;
    private final InputValue inputValue;
    private final MapRepository<Order> orders;
    private final MapRepository<Room> rooms;
    private final MapRepository<Client> clients;
    private final MapRepository<Service> services;

    public OrderMenu() {
        this.logger = MainMenu.getLogger();
        this.rooms = MainMenu.getRooms();
        this.inputValue = MainMenu.getInputValue();
        this.orders = MainMenu.getOrders();
        this.clients = MainMenu.getClients();
        this.services = MainMenu.getServices();
    }

    public void show() {
        System.out.println("1. Поиск заказа\n" +
                           "2. Добавить заказ\n" +
                           "3. Закрыть заказ\n" +
                           "4. Закрыть все заказы по комнате\n" +
                           "5. Закрыть все заказы по постоялцу\n" +
                           "0. Вернуться назад");
        switch (inputValue.entryValidInt("Выбирете действие: ", 0, 5)) {
            case 1:
                new FindOrder().show(orders.read());
                show();
                break;
            case 2:
                new NewOrder().show();
                show();
                break;
            case 3:
                Optional<Map.Entry<Integer, Order>> orderEntry = new SelectValue<Integer, Order>()
                        .show(orders.read(), new FindOrder());
                if (orderEntry.isPresent()) {
                    BigDecimal price = new OrderService(logger, orders, rooms, services).closeOrder(orderEntry.get());
                    System.out.println("Заказ закрыт! Сумма заказа: " + price);
                }
                break;
            case 4:
                Optional<Map.Entry<Integer, Room>> roomEntry = new SelectValue<Integer, Room>()
                        .show(rooms.read(), new FindRoom());
                if (roomEntry.isPresent()) {
                    Map<Integer, Order> ClosedOrders = new MapService<>(orders.read(), logger)
                            .filterByFieldValue("idRoom", roomEntry.get().getKey());
                    BigDecimal price = new OrderService(logger, orders, rooms, services).closeAllOrder(ClosedOrders);
                    System.out.println("Заказы закрыт! Сумма заказов: " + price);
                }
                break;
            case 5:
                Optional<Map.Entry<Integer, Client>> clientEntry = new SelectValue<Integer, Client>()
                        .show(clients.read(), new FindClient());
                if (clientEntry.isPresent()) {
                    Map<Integer, Order> ClosedOrders = new MapService<>(orders.read(), logger)
                            .filterByFieldValue("idClient", clientEntry.get().getKey());
                    BigDecimal price = new OrderService(logger, orders, rooms, services).closeAllOrder(ClosedOrders);
                    System.out.println("Заказы закрыт! Сумма заказов: " + price);
                }
                break;
            case 0:
                break;
        }
    }
}
