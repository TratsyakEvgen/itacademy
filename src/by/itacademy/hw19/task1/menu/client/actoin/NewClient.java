package by.itacademy.hw19.task1.menu.client.actoin;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;

public class NewClient {
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Client> clients;

    public NewClient() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.clients = MainMenu.getClients();
    }


    public void show() {
        String firstName = inputMenuUtil.entryString("Имя: ");
        String lastName = inputMenuUtil.entryString("Фамилия: ");
        String identification = inputMenuUtil.entryString("Номер паспорта: ");
        int age = inputMenuUtil.entryValidInt("Возраст: ", 0, 9999);
        String country = inputMenuUtil.entryString("Страна: ");
        String phoneNumber = inputMenuUtil.entryValidString("Номер телефона: ", "\\+{1}[\\d]{12}");
        clients.add(new Client(firstName, lastName, identification, age, country, phoneNumber));
    }
}
