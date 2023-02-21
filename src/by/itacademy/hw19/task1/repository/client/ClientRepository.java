package by.itacademy.hw19.task1.repository.client;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.service.ioservice.InputService;

import java.util.HashMap;
import java.util.Map;

public class ClientRepository {

    private static ClientRepository instance;

    private Map<String, Client> clients = new HashMap<>();

    private ClientRepository() {
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    private void init() {
        String path = "src/by/itacademy/hw19/task1/data/clients.data";
        InputService inputService = new InputService(path, new ConsoleLogger());
        clients = (Map<String, Client>) inputService.read();
    }


}
