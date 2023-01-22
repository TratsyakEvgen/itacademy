package by.itacademy.hw10.task4.entity.animals;

import java.math.BigDecimal;

public class Animal {
    private final String nickname;
    private final BigDecimal price;

    public Animal(String nickname, BigDecimal price) {
        this.nickname = nickname;
        this.price = price;
    }

    public String getNickname() {
        return nickname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Кличка: " + nickname + "\nЦена: " + price + "\n";
    }


}
