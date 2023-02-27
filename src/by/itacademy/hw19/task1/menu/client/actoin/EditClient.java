package by.itacademy.hw19.task1.menu.client.actoin;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.action.InputValue;
import by.itacademy.hw19.task1.repository.MapRepository;

public class EditClient {

    private final InputValue inputValue;
    private final MapRepository<Client> clients;

    public EditClient() {
        this.inputValue = MainMenu.getInputValue();
        this.clients = MainMenu.getClients();
    }

    public void show(Integer id, Client client) {
        System.out.println("1. Изменть имя\n" +
                           "2. Изменть фамилию\n" +
                           "3. Изменть индификационный номер\n" +
                           "4. Изменть возраст\n" +
                           "5. Изменть страну\n" +
                           "6. Изменть номер телефона\n" +
                           "7. Сохранить изменения\n" +
                           "0. Вернуться назад");

        switch (inputValue.entryValidInt("Выбирете действие: ", 0, 7)) {
            case 1:
                client.setFirstName(inputValue.entryString("Имя: "));
                break;
            case 2:
                client.setLastName(inputValue.entryString("Фамилия: "));
                break;
            case 3:
                client.setIdentification(inputValue.entryString("Номер паспорта: "));
                break;
            case 4:
                client.setAge(inputValue.entryValidInt("Возраст: ", 0, 9999));
                break;
            case 5:
                client.setCountry(inputValue.entryString("Страна: "));
                break;
            case 6:
                client.setPhoneNumber(inputValue.entryString("Номер телефона: "));
                break;
            case 7:
                System.out.println("Информация сохранена");
                clients.update(id, client);
                break;
            case 0:
                return;
        }
        show(id, client);
    }
}
