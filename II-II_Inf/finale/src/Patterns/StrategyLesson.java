package Patterns;

//определяет семейство схожих алгоритмов и помещает каждый из них в собственный класс
//после чего, алгоритмы можно взаимозаменять прямо во время исполнения программы
public class StrategyLesson {
    public static void main(String[] args) {
        double startPrice = 100;
        Context context = new Context(new HalfPrice());
        double price = context.getPrice(startPrice);
        System.out.println(price);
    }
}

interface Strategy {
    double getPrice(Double price);
}

class FullPrice implements Strategy {
    @Override
    public double getPrice(Double price) {
        return price;
    }
}
class HalfPrice implements Strategy {

    @Override
    public double getPrice(Double price) {
        return price * 0.5;
    }
}

class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public double getPrice(double price) {
        return strategy.getPrice(price);
    }
}