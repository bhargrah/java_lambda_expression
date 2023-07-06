package com.collectors.partition;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PartitioningByExample {

  public static void main(String[] args) {

    // Example for numbers
    List<Integer> numberList = Arrays.asList(-2, -1, -10, 56, 0, 1, 2, 3, 4, 5, 6, 7, 8, 8);
    System.out.println(numberList);

    // 1. Split numbers into even and odd data sets
    Map<Boolean, List<Integer>> evenOddNumbers =
        numberList.stream().collect(Collectors.partitioningBy(number -> number % 2 == 0));

    System.out.println(evenOddNumbers.get(true));
    System.out.println(evenOddNumbers.get(false));

    // 2. Split numbers into even and odd data sets and remove negative values
    Map<Boolean, List<Integer>> evenOddNumbersPositiveOnly =
        numberList.stream()
            .filter(number -> number > -1) // filter out negative number
            .collect(Collectors.partitioningBy(number -> number % 2 == 0));

    System.out.println(evenOddNumbersPositiveOnly.get(true));
    System.out.println(evenOddNumbersPositiveOnly.get(false));

    // 3. Split numbers into even and odd data sets and remove negative values
    Map<Boolean, Set<Integer>> evenOddNumbersPositiveSets =
        numberList.stream()
            .filter(number -> number > -1) // filter out negative number
            .collect(Collectors.partitioningBy(number -> number % 2 == 0, Collectors.toSet()));

    System.out.println(evenOddNumbersPositiveSets.get(true));
    System.out.println(evenOddNumbersPositiveSets.get(false));

    // Example for strings
    List<String> names = Arrays.asList("Rahul", "Kanu", "Miraya", "Rudra", "Priya");

    Map<Boolean, List<String>> nameMap =
        names.stream().collect(Collectors.partitioningBy(name -> name.startsWith("R")));

    System.out.println(nameMap.get(true));

    // example for objects

  }
}
