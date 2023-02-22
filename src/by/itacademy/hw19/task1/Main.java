package by.itacademy.hw19.task1;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.menu.ClientMenu;
import by.itacademy.hw19.task1.repository.client.ClientRepository;
import by.itacademy.hw19.task1.service.ClientService;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClientMenu clientMenu = new ClientMenu();
        clientMenu.showClientMenu();
       // ClientRepository clientRepository = ClientRepository.getInstance();
        //<String, Client> map = clientRepository.getClients();

        /*clientRepository.addClient(new Client("Третяк",
                "Евгений",
                "301934983217PB505C0",
                30,
                "Беларусь",
                "+375291234567"));
        clientRepository.addClient(new Client("Иван",
                "Иванов",
                "301934345617RF505C0",
                25,
                "Росссия",
                "+3742998765454"));*/

        //ClientService clientService = new ClientService(new ConsoleLogger());
        //Map<Integer, Client> map = clientService.filterClients("lastName","Иванов");
        //map.forEach((key, value) -> System.out.println(key));
        //System.out.println(clientRepository.getClient(1));

    }
}
