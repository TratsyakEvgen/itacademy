package by.itacademy.hw19.task1.service;

import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.repository.MapRepository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class OrderService {
    private final Logger logger;
    private final MapRepository<Order> orders;
    private final MapRepository<Room> rooms;
    private final MapRepository<Service> services;

    public OrderService(Logger logger,
                        MapRepository<Order> orders,
                        MapRepository<Room> rooms,
                        MapRepository<Service> services) {
        this.logger = logger;
        this.orders = orders;
        this.rooms = rooms;
        this.services = services;
    }


    public BigDecimal closeOrder(Map.Entry<Integer, Order> orderEntry) {
        Order order = orderEntry.getValue();
        int room = order.getIdRoom();
        order.setStatus(false);
        orders.update(orderEntry.getKey(), order);
        MapService<Integer, Order> mapService = new MapService<>(orders.read(), logger);
        mapService.filterByFieldValue("status", true);
        mapService.filterByFieldValue("idRoom", room);
        int idClient = order.getIdRoom();
        if (mapService.filterByFieldValue("idClient", idClient).isEmpty()) {
            Optional<Map.Entry<Integer, Room>> roomEntry =
                    new MapService<>(rooms.read(), logger).getEntryForKey(order.getIdRoom());
            if (roomEntry.isPresent()) {
                new RoomService().evictClientInRoom(roomEntry.get().getValue(), idClient);
                rooms.update(room, roomEntry.get().getValue());
            }
        }
        Optional<Map.Entry<Integer, Service>> serviceEntry =
                new MapService<>(services.read(), logger).getEntryForKey(order.getIdService());
        return serviceEntry
                .get()
                .getValue()
                .getPrice()
                .multiply(BigDecimal.valueOf(order.getNumberOfServices()));
    }

    public BigDecimal closeAllOrder(Map<Integer, Order> Orders) {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Integer, Order> map : Orders.entrySet()) {
            total = total.add(closeOrder(map));
        }
        return total;
    }

}
