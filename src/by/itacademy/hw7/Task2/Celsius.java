package by.itacademy.hw7.Task2;

public class Celsius extends Degree {
    public Celsius() {
        super(-273.15);
    }

    @Override
    public double convertToCelsius() {
        return this.getValue();
    }

    @Override
    public double convertToKelvin() {
        return this.getValue() - 273.15;
    }

    @Override
    public double convertToFahrenheit() {
        return (this.getValue() * 9 / 5) + 32;
    }
}