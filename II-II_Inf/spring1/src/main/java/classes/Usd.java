package classes;

public class Usd {
    private double multiplier = 0.0177;

    public Double convert(double initialVallue){
        return initialVallue * multiplier;
    }

}
