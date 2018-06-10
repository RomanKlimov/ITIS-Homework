package lambdas.Simple;

import java.util.ArrayList;
import java.util.List;

public class Switcher {
    private List<ElectricityConcumer> listeners = new ArrayList<>();

    public void addElectricityListener(ElectricityConcumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener(ElectricityConcumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Выключатель включен");
//        if (consumer != null) {
//            consumer.electricityOn();
//        }
        for(ElectricityConcumer c : listeners) {
            c.electricityOn(this);
        }

    }
}
