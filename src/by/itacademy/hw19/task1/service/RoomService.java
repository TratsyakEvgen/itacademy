package by.itacademy.hw19.task1.service;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Room;

import java.util.Map;

public class RoomService {


    public boolean isClientLivedInRoom(Map.Entry<Integer, Room> room, Map.Entry<Integer, Client> client) {
        return room.getValue()
                .getClients()
                .entrySet()
                .stream()
                .anyMatch(entry -> entry.getValue().equals(client.getValue()));
    }

    public boolean settleClientInRoom(Map.Entry<Integer, Room> roomEntry, Map.Entry<Integer, Client> clientEntry) {
        Room room = roomEntry.getValue();
        Map<Integer, Client> clients = room.getClients();
        if (clients.size() < room.getCapacity()) {
            clients.put(clientEntry.getKey(), clientEntry.getValue());
            return true;
        }
        return false;
    }

    public void evictClientInRoom(Map.Entry<Integer, Room> room, Map.Entry<Integer, Client> client) {
        room.getValue().getClients().remove(client.getKey());
    }

}
