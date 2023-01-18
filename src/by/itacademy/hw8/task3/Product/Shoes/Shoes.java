package by.itacademy.hw8.task3.Product.Shoes;

import by.itacademy.hw8.task3.Product.Product;

public class Shoes extends Product {
    private final String gender;
    private final SizeOfShoes size;

    public Shoes(int barcode, double price, String producer, String model, String gender, SizeOfShoes size) {
        super(barcode, price, producer, model);
        this.gender = gender;
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public SizeOfShoes getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Пол: %s\n" +
                "Размер: %d\n", gender, size.getSize());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Shoes)) {
            return false;
        }

        Shoes shoes = (Shoes) obj;

        return super.equals(obj) ||
                this.gender != null && this.gender.equals(shoes.gender) ||
                this.size.getSize() == shoes.size.getSize();
    }
}
