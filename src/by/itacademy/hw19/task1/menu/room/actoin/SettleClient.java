package by.itacademy.hw19.task1.menu.room.actoin;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.service.RoomService;

import java.util.Map;


public class SettleClient {
    private final InputValue inputValue;

    public SettleClient() {
        this.inputValue = MainMenu.getInputValue();
    }

    public boolean show(Map.Entry<Integer, Room> room, Map.Entry<Integer, Client> client) {
        if (inputValue.entryBoolean("Поселить постояльца:\n1. Да\n2. Нет\n")) {
            if (new RoomService().settleClientInRoom(room, client)) {
                System.out.println("Постоялец заселен!");
                return true;
            } else {
                System.out.println("Номер занят!");

            }
        }
        return false;
    }
}
