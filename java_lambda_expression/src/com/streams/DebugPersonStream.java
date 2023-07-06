package com.streams;

import com.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class DebugPersonStream {

  public static void main(String[] args) {

    Person p1 = new Person("Brian", 23);
    Person p2 = new Person("Alice", 56);
    Person p3 = new Person("Hhelsea", 46);
    Person p4 = new Person("David", 28);
    Person p5 = new Person("Hrica", 37);
    Person p6 = new Person("Francisco", 18);
    Person p7 = new Person("Tom", 16);
    Person p8 = new Person("Alice", 21);
    Person p9 = new Person("David", 18);

    List<Person> personList = new ArrayList<>(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9));

    // Run it in debug mode in inteliJ and check window for debug

    personList.stream()
        .filter(person -> person.getAge() > 18)
        .map(person -> person.getName())
        .filter(name -> !name.startsWith("H"))
        .distinct()
        .sorted()
        .forEach(System.out::println);
  }
}
