package com.collection;

import com.entity.City;
import com.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MainAPICollectionList {

    public static final Consumer<String> printerLamda = s -> System.out.println(s);
    public static final Consumer<String> printerMethod = System.out::println;

    static Person p1 = new Person("Alice", 23);
    static Person p2 = new Person("Brian", 56);
    static Person p3 = new Person("Chelsea", 46);
    static Person p4 = new Person("David", 28);
    static Person p5 = new Person("Erica", 37);
    static Person p6 = new Person("Francisco", 18);
    static Person p7 = new Person("Tom", 16);
    static Person p8 = new Person("Start", 21);
    static Person p9 = new Person("Hank", 18);

    static City newYork = new City("New York");
    static City shanghai = new City("Shanghai");
    static City paris = new City("Paris");

    static List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));

    @SuppressWarnings("unused")
    private static void forEach() {

        printerLamda.accept("\nIterating using lamda - \n");
        people.forEach(person -> System.out.println(person)); // lambda

        printerMethod.accept("\nIterating using lamda - \n");
        people.forEach(System.out::println); // method reference

    }

    @SuppressWarnings("unused")
    private static void removeIf() { // takes predicate , inplace replacement

        printerLamda.accept("\nIterating using lamda - \n");

        Consumer<List<Person>> personLstInterator = people -> people.forEach(person -> System.out.println(person));
        personLstInterator.accept(people);

        // filter person less than < some years of age
        Predicate<Person> ageFilter = p -> p.getAge() < 18; // readable
        people.removeIf(ageFilter);

        people.removeIf(p -> p.getAge() < 20); // single line , same job

        printerLamda.accept("\nAfter filter  - \n");

        personLstInterator.accept(people);

    }

    @SuppressWarnings("unused")
    private static void replaceAll() {

        people.forEach(person -> System.out.println(person.getName()));

        // turn all entries to upper case
        people.replaceAll(person -> new Person(person.getName().toUpperCase(), person.getAge()));

        people.forEach(person -> System.out.println(person.getName()));

    }

    private static void sort() {

        printerLamda.accept("\n\nOriginal List :");
        people.forEach(people -> System.out.print("[ " + people.getName() + " : " + people.getAge() + "],"));
        people.sort(Comparator.comparing(Person::getAge));
        people.sort(Comparator.comparing(person -> person.getAge()));
        printerLamda.accept("\n\nSorted by Age :");
        people.forEach(people -> System.out.print("[ " + people.getName() + " : " + people.getAge() + "],"));

        people.sort(Comparator.comparing(Person::getAge).reversed());
        printerLamda.accept("\n\nSorted by Age (decending):");
        people.forEach(people -> System.out.print("[ " + people.getName() + " : " + people.getAge() + "],"));

        people.sort(Comparator.comparing(Person::getName));
        people.sort(Comparator.comparing(person -> person.getName()));
        printerLamda.accept("\n\nSorted by Name :");
        people.forEach(people -> System.out.print("[ " + people.getName() + " : " + people.getAge() + "],"));

    }

    public static void main(String[] args) {

        // forEach syntax
        forEach();

        // test removeIf
        removeIf();

        // test replaceAll
        replaceAll();

        // test sort
        sort();

        System.out.println("\n\n");

    }

}
