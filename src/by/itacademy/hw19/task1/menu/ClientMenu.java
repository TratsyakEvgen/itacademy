package by.itacademy.hw19.task1.menu;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.menu.action.ClientMenuAction;

import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;

public class ClientMenu {
    private final InputMenuUtil inputMenuUtil;
    private final ClientMenuAction clientMenuAction;
    private final MapRepository<Client> mapRepository;

    public ClientMenu(InputMenuUtil inputMenuUtil, MapRepository<Client> mapRepository) {
        this.inputMenuUtil = inputMenuUtil;
        this.mapRepository = mapRepository;
        this.clientMenuAction = new ClientMenuAction(inputMenuUtil, this.mapRepository);
    }

    public void showClientMenu() {
        System.out.println("1. Поиск клиента\n" +
                           "2. Добавить клиента\n" +
                           "3. Удалить клиента\n" +
                           "4. Изменить клиента\n" +
                           "0. Вернуться назад");
        switch (inputMenuUtil.entryVerifyInt("Выбирете действие: ", 0, 4)) {
            case 1:
                clientMenuAction.filter(mapRepository.read());
                showClientMenu();
                break;
            case 2:
                clientMenuAction.add();
                showClientMenu();
                break;
            case 3:
                clientMenuAction.select().ifPresent(entry -> mapRepository.remove(entry.getKey()));
                showClientMenu();
                break;
            case 4:
                clientMenuAction.select().ifPresent(entry -> clientMenuAction.edit(entry.getKey(), entry.getValue()));
                showClientMenu();
                break;
            case 0:
                break;
        }
    }
}
