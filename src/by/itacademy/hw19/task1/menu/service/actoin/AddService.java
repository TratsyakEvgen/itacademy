package by.itacademy.hw19.task1.menu.service.actoin;

import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.menu.action.SelectValue;

import java.util.Map;

public class AddService {

    private final InputValue inputValue;

    public AddService() {
        this.inputValue = MainMenu.getInputValue();
    }

    public Map<Integer, Service> show(Map<Integer, Service> editable, Map<Integer, Service> services) {
        boolean isAdd = true;
        while (isAdd) {
            if (inputValue.entryBoolean("Добавить сервис:\n1. Да\n2. Нет\n")) {
                new SelectValue<Integer, Service>()
                        .show(services, new FindService())
                        .ifPresent(entry -> editable.put(entry.getKey(), entry.getValue()));
            } else {
                isAdd = false;
            }
        }
        return editable;
    }

}
