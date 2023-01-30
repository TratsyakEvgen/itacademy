package by.itacademy.hw8.task3;


import by.itacademy.hw8.task3.Product.clothes.*;
import by.itacademy.hw8.task3.Product.shoes.Boots;
import by.itacademy.hw8.task3.Product.shoes.SizeOfShoes;
import by.itacademy.hw8.task3.Product.shoes.Slippers;
import by.itacademy.hw8.task3.Product.shoes.Sneakers;
import by.itacademy.hw8.task3.Product.ShopWindow;


public class Main {
    public static void main(String[] args) {

        ShopWindow shopWindow = new ShopWindow();

        shopWindow.add(new Jackets(12345, 199.99, "Китай", "MONCLER", "М", SizeOfClothes.M, true));
        shopWindow.add(new Jackets(12432, 89.99, "Беларусь", "Алеся", "Ж", SizeOfClothes.XS, true));
        shopWindow.add(new Shirts(12433, 6.99, "РФ", "Рубаха", "М", SizeOfClothes.SM, "Классика"));
        shopWindow.add(new Shirts(12493, 68.99, "Германия", "Sanctions", "Ж", SizeOfClothes.S, "Деловой стиль"));
        shopWindow.add(new Trousers(124921, 8.99, "РФ", "Ватники", "М", SizeOfClothes.XL, "Лето"));
        shopWindow.add(new Trousers(124943, 100.99, "Нидерланды", "NL Operations", "М", SizeOfClothes.XXL, "Лето"));
        shopWindow.add(new Boots(1943, 0.99, "РФ", "Валенки", "Ж", SizeOfShoes.S, "Лето"));
        shopWindow.add(new Boots(19675, 0.99, "РФ", "Валенки", "Ж", SizeOfShoes.XXS, "Осень"));
        shopWindow.add(new Slippers(19677, 10.99, "Китай", "Noname", "М", SizeOfShoes.M, "Домашние"));
        shopWindow.add(new Sneakers(19611, 888.99, "США", "Gorilla Wear", "М", SizeOfShoes.S, "Полиуретан"));


        System.out.println("Добро пожаловать в магазин!");

        new StartMenu(shopWindow).start();

    }
}
