package Patterns;

//порождающий паттерн, гарантирует, что у класса есть только один экземпляр и предоставляет к нему глобальную точку доступа.

public class Singleton {
    public static void main(String[] args) {
        Singl singl = Singl.getInstance();
    }
}

class Singl {
    static Singl singl = new Singl();
    private Singl() {

    }

    public static Singl getInstance() {
        return singl;
    }


}
