package com.functional;

import com.entity.Employee;

import java.util.function.BiFunction;

public class BiFunctionExamples {
  public static void main(String[] args) {
    // Calculate Length
    BiFunction<String, String, Integer> lengthSum = (s1, s2) -> s1.length() + s2.length();
    System.out.println("Sum of s1 & s2 length : " + lengthSum.apply("Hello", "sup"));

    // Complex BiFunction
    BiFunction<Employee, String, Boolean> isNamePresent =
        (e1, n1) -> {
          // add validation
          String[] name = n1.split(" ");
          return e1.getFirstName().equalsIgnoreCase(name[0])
              && e1.getLastName().equalsIgnoreCase(name[1]);
        };

    Employee employee = new Employee("Rahul", "Bhargava", 37);

    System.out.println(isNamePresent.apply(employee, "rahul bhargava"));
    // System.out.println(isNamePresent.apply(employee,"rahul"));
    System.out.println(isNamePresent.apply(employee, "kanu bhargava"));
  }
}
