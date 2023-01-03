package by.itacademy.hw7.Task2;

public abstract class Degree{

    private double value;

    protected abstract double convertToCelsius(double value);

    protected abstract double convertToKelvin(double value);

    protected abstract double convertToFahrenheit(double value);

    protected void setValue(double value){
        this.value = value;
    };
    protected double getValue(){
        return this.value;
    };
}
