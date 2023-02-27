package by.itacademy.hw19.task1.service;

import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.repository.MapRepository;

import java.math.BigDecimal;
import java.util.Map;

public class OrderService {
    private final MapRepository<Order> orders;
    private final MapRepository<Room> rooms;

    public OrderService(MapRepository<Order> orders, MapRepository<Room> rooms) {
        this.orders = orders;
        this.rooms = rooms;
    }

    public BigDecimal closeOrder(Map.Entry<Integer, Order> orderEntry) {
        Order order = orderEntry.getValue();
        int key = orderEntry.getKey();
        Map<Integer, Room> room = order.getRoom();
        order.setStatus(false);
        orders.update(orderEntry.getKey(), order);
        new RoomService().evictClientInRoom(order.getRoom().entrySet().stream().findFirst().get(),
                order.getClient().entrySet().stream().findFirst().get());
        rooms.update(key, room.get(key));
        return order
                .getService()
                .entrySet()
                .stream()
                .findFirst()
                .get()
                .getValue().getPrice().multiply(BigDecimal.valueOf(order.getNumberOfServices()));
    }

    public BigDecimal closeAllOrder(Map<Integer, Order> closedOrders) {
        closedOrders.entrySet().forEach(this::closeOrder);
        return closedOrders
                .values()
                .stream()
                .map(order -> order
                        .getService()
                        .entrySet()
                        .stream()
                        .findFirst()
                        .get()
                        .getValue()
                        .getPrice()
                        .multiply(BigDecimal.valueOf(order.getNumberOfServices())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

}
