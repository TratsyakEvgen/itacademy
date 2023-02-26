package by.itacademy.hw19.task1.menu.service;

import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.Select;
import by.itacademy.hw19.task1.menu.service.actoin.DeleteService;
import by.itacademy.hw19.task1.menu.service.actoin.EditService;
import by.itacademy.hw19.task1.menu.service.actoin.FindService;
import by.itacademy.hw19.task1.menu.service.actoin.NewService;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;

public class ServiceMenu {
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Service> services;

    public ServiceMenu() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.services = MainMenu.getServices();
    }

    public void show() {
        System.out.println("1. Поиск сервиса\n" +
                           "2. Добавить сервис\n" +
                           "3. Удалить сервис\n" +
                           "4. Изменить сервис\n" +
                           "0. Вернуться назад");
        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 0, 4)) {
            case 1:
                new FindService().show(services.read());
                show();
                break;
            case 2:
                new NewService().show();
                show();
                break;
            case 3:
                services.write(new DeleteService().show(services.read()));
                show();
                break;
            case 4:
                new Select<Integer, Service>().show(services.read(), new FindService())
                        .ifPresent(entry -> new EditService().show(entry.getKey(), entry.getValue()));
                show();
                break;
            case 0:
                break;
        }
    }
}
