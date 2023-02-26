package by.itacademy.hw19.task1.menu.service.actoin;

import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.Select;
import by.itacademy.hw19.task1.util.InputMenuUtil;

import java.util.Map;

public class DeleteService {
    private final InputMenuUtil inputMenuUtil;

    public DeleteService() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
    }

    public Map<Integer, Service> show(Map<Integer, Service> services) {
        new Select<Integer, Service>().show(services, new FindService()).ifPresent(entry -> {
            System.out.println("Удалить сервис: " +
                               "\n1. Да" +
                               "\n2. Нет");
            switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 1, 2)) {
                case 1:
                    services.remove(entry.getKey(), entry.getValue());
                    break;
                case 2:
                    break;
            }
        });
        return services;
    }
}
