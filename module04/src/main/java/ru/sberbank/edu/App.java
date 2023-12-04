package ru.sberbank.edu;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //first exercise
        doFirstExercise();
        //second exercise
        doSecondExercise();

    }

    private static void doSecondExercise() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alan", "Moscow", 11 ));
        persons.add(new Person("John", "Kaluga", 14 ));
        persons.add(new Person("Anton", "Omsk", 21 ));
        persons.add(new Person("Vazgen", "Moscow", 41 ));
        persons.add(new Person("Alan", "Moscow", 11 ));

        System.out.println();
        System.out.println(persons);
        System.out.println();
        System.out.println("1 и 5 элементы раны?: " + persons.get(0).equals(persons.get(4)) );
        System.out.println("1 и 4 элементы раны?: " + persons.get(0).equals(persons.get(3)) );
        System.out.println();
        System.out.println("hashcode 1:" + persons.get(0).hashCode() );
        System.out.println("hashcode 2:" + persons.get(1).hashCode() );
        System.out.println("hashcode 5:" + persons.get(4).hashCode() );
        System.out.println();
        persons.sort(Person::compareTo);
        System.out.println(persons);
    }

    private static void doFirstExercise() {
        List<Integer> list = new ArrayList<>();
        CustomDigitComparator digitComparator = new CustomDigitComparator();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(10);
        list.add(2);
        list.add(1);

        list.sort(digitComparator);
        System.out.println("After sort by Name of Comparator= " + list);
    }
}
