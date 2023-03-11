package by.itacademy.hw19.task1.menu.client;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.menu.action.SelectValue;
import by.itacademy.hw19.task1.menu.client.actoin.EditClient;
import by.itacademy.hw19.task1.menu.client.actoin.FindClient;
import by.itacademy.hw19.task1.menu.client.actoin.NewClient;
import by.itacademy.hw19.task1.repository.MapRepository;

public class ClientMenu {
    private final InputValue inputValue;
    private final MapRepository<Client> clients;

    public ClientMenu() {
        this.inputValue = MainMenu.getInputValue();
        this.clients = MainMenu.getClients();
    }


    public void show() {
        System.out.println("1. Поиск клиента\n" +
                           "2. Добавить клиента\n" +
                           "3. Удалить клиента\n" +
                           "4. Изменить клиента\n" +
                           "0. Вернуться назад");
        switch (inputValue.entryValidInt("Выбирете действие: ", 0, 4)) {
            case 1:
                new FindClient().show(clients.read());
                show();
                break;
            case 2:
                new NewClient().show();
                show();
                break;
            case 3:
                new SelectValue<Integer, Client>()
                        .show(clients.read(), new FindClient())
                        .ifPresent(entry -> clients.remove(entry.getKey()));
                show();
                break;
            case 4:
                new SelectValue<Integer, Client>()
                        .show(clients.read(), new FindClient())
                        .ifPresent(entry -> new EditClient().show(entry.getKey(), entry.getValue()));
                show();
                break;
            case 0:
                break;
        }
    }
}
