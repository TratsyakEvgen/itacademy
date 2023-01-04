package by.itacademy.hw7.Task2;

public class Fahrenheit extends Degree {
    public Fahrenheit() {
        super(-459.67);
    }

    @Override
    public double convertToCelsius() {
        return (this.getValue() - 32) * 5 / 9;
    }

    @Override
    public double convertToKelvin() {
        return (this.getValue() - 32) * 5 / 9 + 273.15;
    }

    @Override
    public double convertToFahrenheit() {
        return this.getValue();
    }
}
