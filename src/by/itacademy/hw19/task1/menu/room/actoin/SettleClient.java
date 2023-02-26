package by.itacademy.hw19.task1.menu.room.actoin;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.service.RoomService;
import by.itacademy.hw19.task1.util.InputMenuUtil;

import java.util.Map;


public class SettleClient {
    private final InputMenuUtil inputMenuUtil;

    public SettleClient() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
    }

    public boolean show(Map.Entry<Integer, Room> room, Map.Entry<Integer, Client> client) {
        System.out.println("Поселить постояльца: " +
                           "\n1. Да" +
                           "\n2. Нет");
        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 1, 2)) {
            case 1:
                if (new RoomService().settleClientInRoom(room, client)) {
                    System.out.println("Постоялец заселен!");
                    return true;
                } else {
                    System.out.println("Номер занят!");
                }
                break;
            case 2:
                break;
        }
        return false;
    }
}
