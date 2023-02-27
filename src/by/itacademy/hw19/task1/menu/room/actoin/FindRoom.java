package by.itacademy.hw19.task1.menu.room.actoin;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.interfaces.IFindMenu;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.SelectValue;
import by.itacademy.hw19.task1.menu.client.actoin.FindClient;
import by.itacademy.hw19.task1.menu.service.actoin.FindService;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.service.MapService;
import by.itacademy.hw19.task1.menu.action.InputValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class FindRoom implements IFindMenu<Integer, Room> {

    private final Logger logger;
    private final InputValue inputValue;
    private final MapRepository<Service> services;
    private final MapRepository<Client> clients;

    public FindRoom() {
        this.logger = MainMenu.getLogger();
        this.inputValue = MainMenu.getInputValue();
        this.services = MainMenu.getServices();
        this.clients = MainMenu.getClients();
    }

    @Override
    public void show(Map<Integer, Room> rooms) {
        Scanner scanner = new Scanner(System.in);
        MapService<Integer, Room> mapService = new MapService<>(rooms, logger);
        rooms = new HashMap<>();
        System.out.println("1. Поиск по номеру\n" +
                           "2. Поиск по количеству мест\n" +
                           "3. Поиск по постояльцам\n" +
                           "4. Поиск по сервисам\n" +
                           "5. Поиск по описанию\n" +
                           "0. Вернуться назад");

        switch (inputValue.entryValidInt("Выбирете действие: ", 0, 5)) {
            case 1:
                System.out.print("Номер: ");
                rooms = mapService.filterByFieldValue("number", scanner.nextLine());
                break;
            case 2:
                rooms = mapService.filterByFieldValue("capacity",
                        inputValue.entryValidInt("Количество мест: ", 0, 9999));
                break;
            case 3:
                System.out.println("Постоялец: ");
                Optional<Map.Entry<Integer, Client>> client =
                        new SelectValue<Integer, Client>().show(clients.read(), new FindClient());
                if (client.isPresent()) {
                    rooms = mapService.filterByFieldValue("clients", client.get());
                }
                break;
            case 4:
                System.out.println("Сервис: ");
                Optional<Map.Entry<Integer, Service>> service =
                        new SelectValue<Integer, Service>().show(services.read(), new FindService());
                if (service.isPresent()) {
                    rooms = mapService.filterByFieldValue("services", service.get());
                }
                break;
            case 5:
                System.out.print("Описание: ");
                rooms = mapService.filterByFieldValue("description", scanner.nextLine());
                break;
            case 0:
                return;
        }

        if (rooms.isEmpty()) {
            System.out.println("По вашему запросу ничего не найдено :(");
        } else {
            System.out.println(mapService.getString());
            System.out.println("Продолжим поиск из найденых:");
            show(rooms);
        }
    }
}
