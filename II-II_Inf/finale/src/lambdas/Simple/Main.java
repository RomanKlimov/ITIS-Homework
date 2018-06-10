package lambdas.Simple;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        //event subscriber
        switcher.addElectricityListener(lamp);
        switcher.addElectricityListener(radio);

        //анонимный класс
        switcher.addElectricityListener(new ElectricityConcumer() {
            @Override
            public void electricityOn(Object sender) {
                out.println("Пожар");
            }
        });

        String message = "Пожар";
        //внешние переменные можно передавать, только если они final
        //lambda
        switcher.addElectricityListener(sender -> out.println(message));
//        switcher.addElectricityListener(sender -> Main.fire(sender));
//        switcher.addElectricityListener(Main::fire);


        switcher.switchOn();
    }

    public static void fire(Object sender) {
        out.println("Fire!!");
    }
}
