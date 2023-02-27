package by.itacademy.hw19.task1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order implements Serializable {
    private final int idRoom;
    private final int idClient;
    private final int idService;
    private final int numberOfServices;
    private boolean status;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String description;

    public Order(int idRoom,
                 int idClient,
                 int idService,
                 int numberOfServices,
                 LocalDateTime start,
                 LocalDateTime end, String description) {
        this.idRoom = idRoom;
        this.idClient = idClient;
        this.idService = idService;
        this.numberOfServices = numberOfServices;
        this.status = true;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdService() {
        return idService;
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
        return "id Номера: " + idRoom +
               "\nid Постоялеца: " + idClient +
               "\nid Услуги: " + idService +
               "\nКоличество услуг: " + numberOfServices +
               "\nСтатус заказа: " + status +
               "\nДата начала: " + start.format(formatter) +
               "\nДата окончания: " + end.format(formatter) +
               "\nОписание заказа: " + description + "\n\n";
    }
}
