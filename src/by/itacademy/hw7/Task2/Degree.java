package by.itacademy.hw7.Task2;

public abstract class Degree {
    private double value;
    private final double minValue;

    public Degree(double minValue) {
        this.minValue = minValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    protected abstract double convertToCelsius();

    protected abstract double convertToKelvin();

    protected abstract double convertToFahrenheit();
}
