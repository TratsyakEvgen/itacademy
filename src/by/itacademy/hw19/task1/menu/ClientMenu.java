package by.itacademy.hw19.task1.menu;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.repository.client.ClientRepository;
import by.itacademy.hw19.task1.service.ClientService;
import by.itacademy.hw19.task1.util.EntryMenuUtil;
import by.itacademy.hw19.task1.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ClientMenu {
    private final EntryMenuUtil entryMenuUtil = new EntryMenuUtil(new ConsoleLogger());
    private final ClientRepository clientRepository = ClientRepository.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void showClientMenu() {
        System.out.println("1. Поиск клиента\n" +
                           "2. Добавить клиента\n" +
                           "3. Удалить клиента\n" +
                           "4. Изменить клиента\n" +
                           "0. Вернуться назад");
        switch (entryMenuUtil.entryVerifyInt("Выбирете действие: ", 0, 4)) {
            case 1:
                findClient(ClientRepository.getInstance().getClients());
                showClientMenu();
                break;
            case 2:
                addClient();
                showClientMenu();
                break;
            case 3:
                removeClient();
                showClientMenu();
                break;
            case 4:
                editClient(ClientRepository.getInstance().getClients());
                showClientMenu();
                break;
            case 0:
                break;
        }
    }


    public void findClient(Map<Integer, Client> clientMap) {
        ClientService clientService = new ClientService(new ConsoleLogger(), clientMap);
        clientMap = new HashMap<>();
        System.out.println("1. Поиск по имени\n" +
                           "2. Поиск по фамилии\n" +
                           "3. Поиск по индификационному номеру\n" +
                           "4. Поиск по возрасту\n" +
                           "5. Поиск по стране\n" +
                           "6. Поиск по номеру телефона\n" +
                           "0. Вернуться назад");

        switch (entryMenuUtil.entryVerifyInt("Выбирете действие: ", 0, 7)) {
            case 1:
                System.out.print("Имя: ");
                clientMap = clientService.filterClients("firstName", scanner.nextLine());
                break;
            case 2:
                System.out.print("Фамилия: ");
                clientMap = clientService.filterClients("lastName", scanner.nextLine());
                break;
            case 3:
                System.out.print("Номер паспорта: ");
                clientMap = clientService.filterClients("identification", scanner.nextLine());
                break;
            case 4:
                System.out.print("Возраст: ");
                clientMap = clientService.filterClients("age",
                        entryMenuUtil.entryVerifyInt("Выбирете действие: ", 0, 9999));
                break;
            case 5:
                System.out.print("Страна: ");
                clientMap = clientService.filterClients("country", scanner.nextLine());
                break;
            case 6:
                clientMap = clientService.filterClients("phoneNumber",
                        entryMenuUtil.entryVerifyString("Номер телефона: ", "\\+{1}[\\d]{12}"));
                break;
            case 0:
                return;
        }
        if (clientMap.isEmpty()) {
            System.out.println("По вашему запросу ничего не найдено :(");
        } else {
            PrintUtil.printMap(clientMap, ": ");
            System.out.println("Продолжим поиск из найденых клиентов:");
            findClient(clientMap);
        }
    }

    public void addClient() {
        String firstName = entryMenuUtil.entryString("Имя: ");
        String lastName = entryMenuUtil.entryString("Фамилия: ");
        String identification = entryMenuUtil.entryString("Номер паспорта: ");
        int age = entryMenuUtil.entryVerifyInt("Возраст: ",0, 9999);
        String country = entryMenuUtil.entryString("Страна: ");
        String phoneNumber = entryMenuUtil.entryVerifyString("Номер телефона: ","\\+{1}[\\d]{12}");
        clientRepository.addClient(new Client(firstName, lastName, identification, age, country, phoneNumber));
        System.out.println("Клиент добавлен!");
    }


    public void removeClient() {
        System.out.println("Для удаления пользователя необходимо ввести id. " +
                           "Выполним поиск клеента (0 - вернуться назад):");
        findClient(ClientRepository.getInstance().getClients());
        int id = entryMenuUtil.entryVerifyInt("Введите id (0 - вернуться назад): ",0, 2147483647);
        if (id == 0) {
            return;
        }
        clientRepository.removeClient(id);
    }

    public void editClient(Map<Integer, Client> clientMap) {
        System.out.println("Для изменения клиента необходимо ввести id. " +
                           "Выполним поиск клеента (0 - вернуться назад):");
        findClient(ClientRepository.getInstance().getClients());
        int id = entryMenuUtil.entryVerifyInt("Введите id (0 - вернуться назад): ", 0, 2147483647);
        if (id == 0) {
            return;
        }
        clientRepository.getClient(id);
        ClientService clientService = new ClientService(new ConsoleLogger(), clientMap);
        clientMap = new HashMap<>();
        System.out.println("1. Изменть имя\n" +
                           "2. Изменть фамилию\n" +
                           "3. Изменть индификационный номер\n" +
                           "4. Изменть возраст\n" +
                           "5. Изменть страну\n" +
                           "6. Изменть номер телефона\n" +
                           "0. Вернуться назад");

        switch (entryMenuUtil.entryVerifyInt("Выбирете действие: ",0, 7)) {
            case 1:
                String firstName = entryMenuUtil.entryString("Имя: ");
                clientMap = clientService.filterClients("firstName", scanner.nextLine());
                break;
            case 2:
                System.out.print("Фамилия: ");
                clientMap = clientService.filterClients("lastName", scanner.nextLine());
                break;
            case 3:
                System.out.print("Номер паспорта: ");
                clientMap = clientService.filterClients("identification", scanner.nextLine());
                break;
            case 4:
                clientMap = clientService.filterClients("age",
                        entryMenuUtil.entryVerifyInt("Возраст: ",0, 9999));
                break;
            case 5:
                System.out.print("Страна: ");
                clientMap = clientService.filterClients("country", scanner.nextLine());
                break;
            case 6:
                clientMap = clientService.filterClients("phoneNumber",
                        entryMenuUtil.entryVerifyString("Номер телефона: ","\\+{1}[\\d]{12}"));
                break;
            case 0:
                return;
        }
        if (clientMap.isEmpty()) {
            System.out.println("По вашему запросу ничего не найдено :(");
        } else {
            PrintUtil.printMap(clientMap, ": ");
            System.out.println("Продолжим поиск из найденых клиентов:");
            findClient(clientMap);
        }
    }


}
