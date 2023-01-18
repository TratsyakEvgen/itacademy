package by.itacademy.hw8.task3.Product.Shoes;


public class Boots extends Shoes {
    private final String season;

    public Boots(int barcode, double price, String producer, String model, String gender, SizeOfShoes size, String season) {
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

        if (!(obj instanceof Boots)) {
            return false;
        }

        Boots boots = (Boots) obj;

        return super.equals(obj) ||
                this.season != null && this.season.equals(boots.season);
    }
}
