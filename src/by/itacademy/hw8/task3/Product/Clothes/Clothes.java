package by.itacademy.hw8.task3.Product.Clothes;

import by.itacademy.hw8.task3.Product.Product;

public class Clothes extends Product {
    private final String gender;
    private final SizeOfClothes size;

    public Clothes(int barcode, double price, String producer, String model, String gender, SizeOfClothes size) {
        super(barcode, price, producer, model);
        this.gender = gender;
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public SizeOfClothes getSize() {
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

        if (!(obj instanceof Clothes)) {
            return false;
        }

        Clothes clothes = (Clothes) obj;

        return super.equals(obj) ||
                this.gender != null && this.gender.equals(clothes.gender) ||
                this.size.getSize() == clothes.size.getSize();
    }
}
