package by.itacademy.hw19.task1.menu.room.actoin;

import by.itacademy.hw19.task1.entity.Room;
import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.service.actoin.AddService;
import by.itacademy.hw19.task1.menu.service.actoin.DeleteService;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.service.MapService;
import by.itacademy.hw19.task1.util.InputMenuUtil;

public class EditRoom {

    private final Logger logger;
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Room> rooms;
    private final MapRepository<Service> services;

    public EditRoom() {
        this.logger = MainMenu.getLogger();
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.rooms = MainMenu.getRooms();
        this.services = MainMenu.getServices();
    }

    public void show(Integer id, Room room) {
        System.out.println("1. Изменть номер\n" +
                           "2. Изменть количество мест\n" +
                           "3. Добавить услугу номера\n" +
                           "4. Удалить услугу номера\n" +
                           "5. Изменть описание\n" +
                           "6. Сохранить изменения\n" +
                           "0. Вернуться назад");

        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 0, 6)) {
            case 1:
                room.setNumber(inputMenuUtil.entryString("Номер: "));
                break;
            case 2:
                room.setCapacity(inputMenuUtil.entryValidInt("Количество мест: ", 0, 9999));
                break;
            case 3:
                System.out.println("Список услуг номера:");
                System.out.println(new MapService<>(room.getServices(), logger).getString());
                new AddService().show(room.getServices(), services.read());
                break;
            case 4:
                System.out.println("Список услуг номера:");
                System.out.println(new MapService<>(room.getServices(), logger).getString());
                new DeleteService().show(room.getServices());
                break;
            case 5:
                room.setDescription(inputMenuUtil.entryString("Описание: "));
                break;
            case 6:
                System.out.println("Информация сохранена");
                rooms.update(id, room);
                break;
            case 0:
                return;
        }
        show(id, room);
    }
}
