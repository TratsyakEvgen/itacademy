package by.itacademy.hw19.task1.repository.client;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.repository.client.ioperation.InputOperation;
import by.itacademy.hw19.task1.repository.client.ioperation.OutputOperation;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClientRepository {
    private static final String PATH = "src/by/itacademy/hw19/task1/data/clients.data";
    private static ClientRepository instance;
    private Map<Integer, Client> clients = new LinkedHashMap<>();


    private ClientRepository() {
        read();
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }

    private void read() {
        InputOperation inputOperation = new InputOperation(PATH, new ConsoleLogger());
        Object object = inputOperation.read();
        if (object instanceof Map<?, ?>) {
            clients = (Map<Integer, Client>) inputOperation.read();
        }
    }

    public void addClient(Client client) {
        Integer id = clients.keySet().stream().max(Integer::compare).orElse(1);
        clients.put(id + 1, client);
        OutputOperation outputOperation = new OutputOperation(PATH, new ConsoleLogger());
        outputOperation.write(clients);
    }

    public void removeClient(Integer id) {
        clients.remove(id);
        OutputOperation outputOperation = new OutputOperation(PATH, new ConsoleLogger());
        outputOperation.write(clients);
    }



    public void getClient(Integer key) {
        clients.get(key);
    }

}
