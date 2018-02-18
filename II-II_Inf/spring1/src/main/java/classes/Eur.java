package classes;

public class Eur {
    private double multiplier = 0.0141;

    public Double convert(double initialVallue){
        return initialVallue * multiplier;
    }
}
