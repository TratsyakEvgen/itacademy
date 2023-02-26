package by.itacademy.hw19.task1.menu.service.actoin;

import by.itacademy.hw19.task1.entity.Service;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;

import java.math.BigDecimal;

public class EditService {
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Service> services;

    public EditService() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.services = MainMenu.getServices();
    }

    public void show(Integer id, Service service) {
        System.out.println("1. Изменть название\n" +
                           "2. Изменть цену\n" +
                           "3. Изменть описание\n" +
                           "4. Сохранить изменения\n" +
                           "0. Вернуться назад");

        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 0, 4)) {
            case 1:
                service.setName(inputMenuUtil.entryString("Название: "));
                break;
            case 2:
                service.setPrice(new BigDecimal(
                        inputMenuUtil.entryValidString("Цена: ", "\\d+.{1}\\d{2}")));
                break;
            case 3:
                service.setDescription(inputMenuUtil.entryString("Описание: "));
                break;
            case 4:
                System.out.println("Информация сохранена");
                services.update(id, service);
                break;
            case 0:
                return;
        }
        show(id, service);
    }
}

