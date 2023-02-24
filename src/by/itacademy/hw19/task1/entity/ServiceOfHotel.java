package by.itacademy.hw19.task1.entity;

import java.math.BigDecimal;

public class ServiceOfHotel {
    private String name;
    private BigDecimal price;
    private String description;

    public ServiceOfHotel(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Название: " + name + "\n" +
               "Цена: " + price  + "\n" +
               "Описание: " + description;
    }
}
