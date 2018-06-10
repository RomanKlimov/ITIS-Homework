package lambdas.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Сергей", 38));
        persons.add(new Person("Даша", 7));
        persons.add(new Person("Глаша", 18));
        persons.add(new Person("Саша", 14));
        persons.add(new Person("Анна", 21));


        //императивный подход
//        for(Person p : persons) {
//            System.out.println(p);
//        }

        //декларативный подход
//        persons.stream().forEach(person -> System.out.println(person));
//        persons.stream().forEach(System.out::println);
        //filter возвращает boolean
//        persons.stream().filter(person -> {
//            return person.getAge() >= 18;
//        }).forEach(System.out::println);

        persons.stream().
                filter(p -> p.getAge() >= 18).
                sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).
                map(p -> p.getName()).
                forEach(
                        //(String name) -> System.out.println(name)
                        System.out::println);


        //посчитать средний возраст людей, которым больше 18 лет
        int summa = 0;
        int adultPerson = 0;
        for (Person p: persons) {
            if(p.getAge() >= 18) {
                summa += p.getAge();
                adultPerson ++;
            }
        }

        int averageAge = summa/adultPerson;
        System.out.println(averageAge);

        //декларативный подход
        int averageAge2 = (int)persons.stream().
                filter(p -> p.getAge() >= 18).
                mapToInt(p -> p.getAge()).average().getAsDouble();
        System.out.println(averageAge2);
    }

}
