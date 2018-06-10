//package Patterns;
//
////позволяет создавать семейства связанных объектов, не привязываясь к конкретным классам создаваемых объектов.
//public class AbstractFactoryLesson {
//    public static void main(String[] args) {
//        Factory carFactory = new AbstractFactory().creayteFactory("CarFactory");
//        Factory tankFactory = new AbstractFactory().creayteFactory("TankFactory");
//
//        Car toyota = carFactory.createCar("Toyota");
//        toyota.drive();
//
//        Tank t51 = tankFactory.createTank("T51");
//        t51.drive();
//
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
//class CarFactory implements Factory{
//    public Car createCar(String typeOfCar) {
//        switch (typeOfCar) {
//            case "Toyota" : return new Toyota();
//            case "Audi" : return new Audi();
//            default: return null;
//        }
//    }
//
//    @Override
//    public Tank createTank(String typeOfTank) {
//        return null;
//    }
//}
//
//interface Tank {
//    void drive();
//}
//
//class T51 implements Tank {
//
//    @Override
//    public void drive() {
//        System.out.println("Driving T51");
//    }
//}
//
//class T52 implements Tank {
//
//    @Override
//    public void drive() {
//        System.out.println("Driving T52");
//    }
//}
//
//class TankFactory implements Factory{
//    public Tank createTank(String typeOfTank) {
//        switch (typeOfTank) {
//            case "T51" : return new T51();
//            case "T52" : return new T52();
//            default: return null;
//        }
//    }
//
//    @Override
//    public Car createCar(String typeOfCar) {
//        return null;
//    }
//}
//
//interface Factory {
//    Car createCar(String typeOfCar);
//    Tank createTank(String typeOfTank);
//
//}
//
//class AbstractFactory {
//    Factory creayteFactory (String typeOfFactory) {
//        switch (typeOfFactory) {
//            case "TankFactory" : return new TankFactory();
//            case "CarFactory" : return new CarFactory();
//            default: return null;
//        }
//    }
//}
//
//
