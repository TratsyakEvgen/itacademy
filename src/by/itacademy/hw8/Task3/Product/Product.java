package by.itacademy.hw8.Task3.Product;

public class Product {
    private final int barcode;
    private final double price;
    private final String producer;
    private final String model;

    public Product(int barcode, double price, String producer, String model) {
        this.barcode = barcode;
        this.price = price;
        this.producer = producer;
        this.model = model;
    }

    public int getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("Штрих - код: %d\n" +
                "Цена: %f\n" +
                "Изготовитель: %s\n" +
                "Модель: %s\n", barcode, price, producer, model);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Product)) {
            return false;
        }

        Product product = (Product) obj;

        return this.barcode == product.barcode ||
                this.price == product.price ||
                this.producer != null && this.producer.equals(product.producer) ||
                this.model != null && this.model.equals(product.model);
    }
}
