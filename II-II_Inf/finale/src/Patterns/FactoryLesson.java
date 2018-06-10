//package Patterns;
//
//
//создает экземпляры класса, реализация определяется в подклассах
//public class FactoryLesson {
//    public static void main(String[] args) {
//        CarFactory factory = new CarFactory();
//
//        Car toyota = factory.create("Toyota");
//        Car audi = factory.create("Audi");
//
//        toyota.drive();
//        audi.drive();
//
//    }
//}
//
//interface Car {
//    void drive();
//}
//
//class Toyota implements Car {
//
//    @Override
//    public void drive() {
//        System.out.println("Driving Toyota");
//    }
//}
//
//class Audi implements Car {
//
//    @Override
//    public void drive() {
//        System.out.println("Driving Audi");
//    }
//}
//
//class CarFactory {
//    public Car create(String typeOfCar) {
//        switch (typeOfCar) {
//            case "Toyota" : return  new Toyota();
//            case "Audi" : return new Audi();
//            default: return null;
//        }
//    }
//}
