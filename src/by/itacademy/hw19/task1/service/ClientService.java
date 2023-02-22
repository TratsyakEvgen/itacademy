package by.itacademy.hw19.task1.service;


import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.logger.Logger;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;


public class ClientService {
    private final Map<Integer, Client> clients;
    private final Logger logger;

    public ClientService(Logger logger, Map<Integer, Client> clientRepository) {
        this.logger = logger;
        this.clients = clientRepository;
    }

    public <T> Map<Integer, Client> filterClients(String fieldName, T value){
        return  clients.entrySet().stream().filter(entry -> {
            Object client = entry.getValue();
            try {
                Field field = client.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(client).equals(value);
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
                logger.write("Ошибка! " + this.getClass() + "\n" + e.getMessage());
            }
            return false;
        }).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }





}
