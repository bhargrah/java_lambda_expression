package com.var.usages;

import com.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Usage {

    public static Person p1 = new Person("Alice", 23);
    public static Person p2 = new Person("Brian", 56);
    public static Person p3 = new Person("Chelsea", 46);
    public static Person p4 = new Person(null, 28);
    public static Person p5 = new Person("Erica", 37);
    public static Person p6 = new Person("Francisco", 18);
    public static Person p7 = new Person("Tom", 16);
    public static Person p8 = new Person("Start", 21);
    public static Person p9 = new Person("Hank", 18);


    public static List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));

    public static void main(String[] args) {


        // regular looping
        List<String> nameList = people.stream()
                .map(people -> people.getName())
                .collect(Collectors.toList());

        System.out.println(nameList); // null is present

        // regular looping
        List<String> nameList1 = people.stream()
                .map(people -> people.getName())
                .filter(name -> name != null)
                .collect(Collectors.toList());

        System.out.println(nameList1); // null removed

        // var syntax
        var nameList2 = people.stream()
                .map(people -> people.getName())
                //				      .map((@Notnull var name) -> name.toUpperCase()) // fix this
                .collect(Collectors.toList());

        System.out.println(nameList2); // null removed

        // In java 11 you can call java Factorial.java 4 directly from shell file
        // .Factorial.java 4 -- sample


    }

}
