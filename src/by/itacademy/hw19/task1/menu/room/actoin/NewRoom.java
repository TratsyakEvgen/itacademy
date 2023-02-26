package by.itacademy.hw19.task1.menu.room.actoin;

import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.service.actoin.AddService;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;

import java.util.HashMap;
import java.util.Map;

public class NewRoom {
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Room> rooms;
    private final MapRepository<Service> services;

    public NewRoom() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.rooms = MainMenu.getRooms();
        this.services = MainMenu.getServices();
    }

    public void show() {
        String number = inputMenuUtil.entryString("Номер: ");
        int capacity = inputMenuUtil.entryValidInt("Количестов мест: ", 0, 9999);
        Map<Integer, Service> servicesOfRoom = new AddService().show(new HashMap<>(), services.read());
        String description = inputMenuUtil.entryString("Описание: ");
        rooms.add(new Room(number, capacity, servicesOfRoom, description));
    }
}
