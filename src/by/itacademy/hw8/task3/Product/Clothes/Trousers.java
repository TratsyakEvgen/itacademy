package by.itacademy.hw8.task3.Product.Clothes;

public class Trousers extends Clothes {
    private final String season;

    public Trousers(int barcode, double price, String producer, String model, String gender, SizeOfClothes size, String season) {
        super(barcode, price, producer, model, gender, size);
        this.season = season;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Сезон: %s\n", season);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Trousers)) {
            return false;
        }

        Trousers trousers = (Trousers) obj;

        return super.equals(obj) ||
                this.season != null && this.season.equals(trousers.season);
    }
}
