package by.itacademy.hw19.task1.menu.service.actoin;

import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;

import java.math.BigDecimal;

public class NewService {

    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Service> services;

    public NewService() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.services = MainMenu.getServices();
    }

    public void show() {
        String name = inputMenuUtil.entryString("Название: ");
        BigDecimal price = new BigDecimal(inputMenuUtil.entryValidString("Цена: ", "\\d+.{1}\\d{2}"));
        String description = inputMenuUtil.entryString("Описание: ");
        services.add(new Service(name, price, description));
    }
}
