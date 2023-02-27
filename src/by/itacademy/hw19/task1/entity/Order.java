package by.itacademy.hw19.task1.entity;

import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.service.MapService;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Order implements Serializable {
    private final Map<Integer, Room> room;
    private final Map<Integer, Client> client;
    private final Map<Integer, Service> service;
    private final int numberOfServices;
    private boolean status;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String description;

    public Order(Map<Integer, Room> room,
                 Map<Integer, Client> client,
                 Map<Integer, Service> service,
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

    public Map<Integer, Room> getRoom() {
        return room;
    }

    public Map<Integer, Client> getClient() {
        return client;
    }

    public Map<Integer, Service> getService() {
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
        return "Номер:\n" + new MapService<>(room, new ConsoleLogger()).getString() +
               "\nПостоялец:\n" + new MapService<>(client, new ConsoleLogger()).getString() +
               "Услуга:\n" + new MapService<>(service, new ConsoleLogger()).getString() +
               "Количество услуг: " + numberOfServices +
               "\nСтатус заказа: " + status +
               "\nДата начала: " + start.format(formatter) +
               "\nДата окончания: " + end.format(formatter) +
               "\nОписание заказа: " + description + "\n\n";
    }
}
