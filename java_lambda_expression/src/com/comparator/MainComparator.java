package com.comparator;

import com.entity.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainComparator {

  @SuppressWarnings("unused")
  public static void main(String... args) {

    Comparator<Employee> cmpAge =
        (p1, p2) -> p2.getAge() - p1.getAge(); // leveraging compare method
    Comparator<Employee> cmpFirstName =
        (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()); // leveraging compare method
    Comparator<Employee> cmpLastName =
        (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()); // leveraging compare method

    Function<Employee, Integer> f1 = p -> p.getAge();
    Function<Employee, String> f2 = p -> p.getLastName();
    Function<Employee, String> f3 = p -> p.getFirstName();

    Function<Employee, Integer> f11 = Employee::getAge;

    Function<Employee, Integer> f_lambda = p -> p.getAge();
    Function<Employee, Integer> f_method_refrence = Employee::getAge;

    // Comparator<Employee> cmpEmployeeAge_v1 = Comparator.comparing(f_lambda);
    // Comparator<Employee> cmpEmployeeAge_v2 = Comparator.comparing(f_method_refrence);

    Comparator<Employee> cmpEmployeeAge_v3 = Comparator.comparing(Employee::getAge);
    Comparator<Employee> cmpEmployeeAge_v4 = Comparator.comparing(p -> p.getAge());

    Comparator<Employee> cmpEmployeeAge = Comparator.comparing(Employee::getAge);
    Comparator<Employee> cmpEmployeeLastName = Comparator.comparing(Employee::getLastName);

    // Chaining comparators
    Comparator<Employee> cmp =
        Comparator.comparing(Employee::getLastName)
            .thenComparing(Employee::getFirstName)
            .thenComparing(Employee::getAge);

    BinaryOperator<Integer> sub = (i1, i2) -> i1 - i2;
    BinaryOperator<Integer> sum = (i1, i2) -> Integer.sum(i1, i2);
    BinaryOperator<Integer> max = Math::max;

    Consumer<String> printer = s -> System.out.println(s);
    Consumer<String> printer1 = System.out::println;

    List<Employee> EmployeeList = createTestData();
    // Collections.sort(EmployeeList,cmpAge);
    System.out.println((EmployeeList));
    java.util.Comparator<Employee> cmpAgeLocal = (p1, p2) -> p2.getAge() - p1.getAge();
    Collections.sort(EmployeeList, cmpAgeLocal);
    System.out.println((EmployeeList));
  }

  public static List<Employee> createTestData() {

    List<Employee> EmployeeList = new ArrayList<>();

    Employee rahul = new Employee("Rahul", "Bhargava", 35);
    Employee kanu = new Employee("Kanu", "Bhargava", 33);
    Employee sonal = new Employee("Sonal", "Agarwal", 33);
    Employee idu = new Employee("Idu", "Agarwal", 4);
    Employee miraya = new Employee("Miraya", "Bhargava", 2);

    EmployeeList.add(miraya);
    EmployeeList.add(kanu);
    EmployeeList.add(sonal);
    EmployeeList.add(idu);
    EmployeeList.add(rahul);

    return EmployeeList;
  }
}
