package by.itacademy.hw19.task1.entity;

import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.service.MapService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Room implements Serializable {
    private String number;
    private int capacity;
    private Map<Integer, Client> clients = new HashMap<>();
    private Map<Integer, Service> services;
    private String description;

    public Room(String number, int capacity, Map<Integer, Service> services, String description) {
        this.number = number;
        this.capacity = capacity;
        this.services = services;
        this.description = description;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }


    public Map<Integer, Service> getServices() {
        return services;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Номер : " + number +
               "\nКоличество мест в номере: " + capacity +
               "\nПостояльцы номера:\n" + new MapService<>(clients, new ConsoleLogger()).getString() +
               "Предоставляемые услуги номера:\n" + new MapService<>(services, new ConsoleLogger()).getString() +
               "Описание номера: " + description;
    }
}
