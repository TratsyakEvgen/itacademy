package by.itacademy.hw19.task1.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Order {
    private final Map.Entry<Integer, Room> room;
    private final Map.Entry<Integer, Client> client;
    private final Map.Entry<Integer, Service> service;
    private final int numberOfServices;
    private boolean status;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String description;

    public Order(Map.Entry<Integer, Room> room,
                 Map.Entry<Integer, Client> client,
                 Map.Entry<Integer, Service> service,
                 int numberOfServices,
                 LocalDateTime start,
                 LocalDateTime end, String description) {
        this.room = room;
        this.client = client;
        this.service = service;
        this.numberOfServices = numberOfServices;
        this.status = true;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public Map.Entry<Integer, Room> getRoom() {
        return room;
    }

    public Map.Entry<Integer, Client> getClient() {
        return client;
    }

    public Map.Entry<Integer, Service> getService() {
        return service;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Номер: " + room +
               "\nПостоялец:\n" + client +
               "\nУслуга:\n" + service +
               "\nКоличество услуг: " + numberOfServices +
               "\nСтатус заказа: " + status +
               "\nДата начала: " + start.format(formatter) +
               "\nДата окончания: " + end.format(formatter) +
               "\nОписание заказа: " + description;
    }
}
