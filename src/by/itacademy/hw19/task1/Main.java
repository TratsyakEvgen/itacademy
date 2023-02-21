package by.itacademy.hw19.task1;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.repository.client.ClientRepository;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClientRepository clientRepository = ClientRepository.getInstance();
        Map<String, Client> map = clientRepository.getClients();
    }
}
