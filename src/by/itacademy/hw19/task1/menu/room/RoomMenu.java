package by.itacademy.hw19.task1.menu.room;

import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.Select;
import by.itacademy.hw19.task1.menu.room.actoin.EditRoom;
import by.itacademy.hw19.task1.menu.room.actoin.FindRoom;
import by.itacademy.hw19.task1.menu.room.actoin.NewRoom;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;

public class RoomMenu {
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Room> rooms;

    public RoomMenu() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.rooms = MainMenu.getRooms();
    }

    public void show() {
        System.out.println("1. Поиск комнаты\n" +
                           "2. Добавить комнату\n" +
                           "3. Удалить комнату\n" +
                           "4. Изменить комнату\n" +
                           "0. Вернуться назад");
        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 0, 4)) {
            case 1:
                new FindRoom().show(rooms.read());
                show();
                break;
            case 2:
                new NewRoom().show();
                show();
                break;
            case 3:
                new Select<Integer, Room>()
                        .show(rooms.read(), new FindRoom())
                        .ifPresent(entry -> rooms.remove(entry.getKey()));
                show();
                break;
            case 4:
                new Select<Integer, Room>()
                        .show(rooms.read(), new FindRoom())
                        .ifPresent(entry -> new EditRoom().show(entry.getKey(), entry.getValue()));
                show();
                break;
            case 0:
                break;
        }
    }
}
