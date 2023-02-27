package by.itacademy.hw19.task1.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Service implements Serializable {
    private String name;
    private BigDecimal price;
    private String description;

    public Service(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Название услуги: " + name +
               "\nЦена услуги: " + price +
               "\nОписание услуги: " + description + "\n";
    }
}
