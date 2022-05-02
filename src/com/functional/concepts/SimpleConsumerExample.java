package com.functional.concepts;

import com.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SimpleConsumerExample {

    static Person p1 = new Person("Alice", 23);
    static Person p2 = new Person("Brian", 56);
    static Person p3 = new Person("Chelsea", 46);
    static Person p4 = new Person("David", 28);
    static Person p5 = new Person("Erica", 37);
    static Person p6 = new Person("Francisco", 18);
    static Person p7 = new Person("Tom", 16);
    static Person p8 = new Person("Start", 21);
    static Person p9 = new Person("Hank", 18);

    static List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));

    public static void main(String[] args) {

        SimpleConsumer<String> printString = s -> System.out.println(s);
        printString.accept("Hello");

        Consumer<Person> printName = p -> System.out.println(p.getName());
        people.forEach(printName);


    }

}
