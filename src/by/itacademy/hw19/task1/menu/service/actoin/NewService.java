package by.itacademy.hw19.task1.menu.service.actoin;

import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.repository.MapRepository;

import java.math.BigDecimal;

public class NewService {

    private final InputValue inputValue;
    private final MapRepository<Service> services;

    public NewService() {
        this.inputValue = MainMenu.getInputValue();
        this.services = MainMenu.getServices();
    }

    public void show() {
        String name = inputValue.entryString("Название: ");
        BigDecimal price = new BigDecimal(inputValue.entryValidString("Цена: ", "\\d+.{1}\\d{2}"));
        String description = inputValue.entryString("Описание: ");
        services.add(new Service(name, price, description));
    }
}
