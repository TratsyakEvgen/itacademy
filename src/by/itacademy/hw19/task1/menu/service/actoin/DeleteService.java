package by.itacademy.hw19.task1.menu.service.actoin;

import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.menu.action.SelectValue;

import java.util.Map;

public class DeleteService {
    private final InputValue inputValue;

    public DeleteService() {
        this.inputValue = MainMenu.getInputValue();
    }

    public Map<Integer, Service> show(Map<Integer, Service> services) {
        new SelectValue<Integer, Service>().show(services, new FindService()).ifPresent(entry -> {
            if (inputValue.entryBoolean("Удалить сервис:\n1. Да\n2. Нет\n")) {
                services.remove(entry.getKey(), entry.getValue());
            }
        });
        return services;
    }
}
