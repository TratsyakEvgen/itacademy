package by.itacademy.hw19.task1.menu.room.actoin;

import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.service.actoin.AddService;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.menu.action.InputValue;

import java.util.HashMap;
import java.util.Map;

public class NewRoom {
    private final InputValue inputValue;
    private final MapRepository<Room> rooms;
    private final MapRepository<Service> services;

    public NewRoom() {
        this.inputValue = MainMenu.getInputValue();
        this.rooms = MainMenu.getRooms();
        this.services = MainMenu.getServices();
    }

    public void show() {
        String number = inputValue.entryValidString("Номер: ", "\\S+.*");
        int capacity = inputValue.entryValidInt("Количестов мест: ", 0, 9999);
        Map<Integer, Service> servicesOfRoom = new AddService().show(new HashMap<>(), services.read());
        String description = inputValue.entryString("Описание: ");
        rooms.add(new Room(number, capacity, servicesOfRoom, description));
    }
}
