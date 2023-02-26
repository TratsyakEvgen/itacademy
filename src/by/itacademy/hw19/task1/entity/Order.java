package by.itacademy.hw19.task1.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private Room room;
    private Client client;
    private Service service;
    private int numberOfServices;
    private boolean status;
    private LocalDateTime start;
    private LocalDateTime end;
    private String description;

    public Order(Room room,
                 Client client,
                 Service service,
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

    public Room getRoom() {
        return room;
    }

    public Client getClient() {
        return client;
    }

    public Service getService() {
        return service;
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public String getDescription() {
        return description;
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
