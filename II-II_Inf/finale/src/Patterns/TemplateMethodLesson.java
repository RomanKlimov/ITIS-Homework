package Patterns;

//Поведенческий паттерн, определяет структура алгоритма, передавай ответственность за некоторые его шаги
//на подклассы. Позволяет перееопределить шаги алгоритма, но не меняя общей структуры(порядка выполнения методов)

public class TemplateMethodLesson {
    public static void main(String[] args) {
        Game game = new Poker();
        game.run();
    }
}

abstract class Game {
    abstract void startGame();
    abstract void play();
    abstract void endGame();

    void run() {
        startGame();
        play();
        endGame();
    }
}

class Poker extends Game {

    @Override
    void startGame() {
        System.out.println("starting");
    }

    @Override
    void play() {
        System.out.println("playing");
    }

    @Override
    void endGame() {
        System.out.println("ending");
    }
}