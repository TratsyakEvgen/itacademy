package by.itacademy.hw19.task1.menu.client.actoin;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.menu.action.InputValue;

public class NewClient {
    private final InputValue inputValue;
    private final MapRepository<Client> clients;

    public NewClient() {
        this.inputValue = MainMenu.getInputValue();
        this.clients = MainMenu.getClients();
    }


    public void show() {
        String firstName = inputValue.entryValidString("Имя: ","\\S+.*");
        String lastName = inputValue.entryValidString("Фамилия: ","\\S+.*");
        String identification = inputValue.entryValidString("Номер паспорта: ","\\S+.*");
        int age = inputValue.entryValidInt("Возраст: ", 0, 9999);
        String country = inputValue.entryValidString("Страна: ","\\S+.*");
        String phoneNumber = inputValue.entryValidString("Номер телефона: ", "\\+{1}[\\d]{12}");
        clients.add(new Client(firstName, lastName, identification, age, country, phoneNumber));
    }
}
