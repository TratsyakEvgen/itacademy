package by.itacademy.hw7.Task2;

public class Kelvin extends Degree {
    public Kelvin() {
        super(0);
    }

    @Override
    public double convertToCelsius() {
        return this.getValue() - 273.15;
    }

    @Override
    public double convertToKelvin() {
        return this.getValue();
    }

    @Override
    public double convertToFahrenheit() {
        return (this.getValue() - 273.15) * 9 / 5 + 32;
    }
}
