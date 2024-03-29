package com.streams;

import com.entity.City;
import com.entity.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainBuildingStreams {

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

  public static void main(String[] args) throws IOException {

    // syntax();

    // mapFilterReduce();

    // skipLimit();

    matchReductions();

    findReduction();

    reduceReduction();
  }

  private static void reduceReduction() {

    // people.stream().reduce((p1,p2) -> p1.getAge()+p2.getAge());

  }

  private static void findReduction() {

    // findFirst
    // findAny

    Optional<Person> opt = people.stream().findFirst().filter(p -> p.getAge() > 20);
    // if(opt.isPresent())
    // opt.

  }

  private static void matchReductions() {

    // anyMatch
    // allMatch
    // noneMatch

    // all are terminal operations , short circuiting terminal operation

    // write the samples

    System.out.println(people.stream().anyMatch(p -> p.getAge() < 15));
  }

  private static void skipLimit() {

    people.forEach(s -> System.out.print(s + " -> "));

    System.out.println("");

    people.stream()
        .skip(2) // skip first two element
        .limit(3) // select number of record to be processed , in this case only  ar processed
        .filter(p -> p.getAge() > 20)
        .forEach(System.out::println); // trigger computation
  }

  private static void syntax() throws IOException {

    List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);

    Stream<Integer> stream1 = ints.stream();
    Stream<Integer> stream = Stream.of(0, 1, 2, 3, 4);

    stream.forEach(System.out::println);

    Stream<String> streamOfStrings = Stream.generate(() -> "one");
    streamOfStrings.limit(5).forEach(System.out::println);

    Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+");
    streamOfStrings2.limit(5).forEach(System.out::println);

    IntStream streamOfInt = ThreadLocalRandom.current().ints();
    streamOfInt.limit(5).forEach(System.out::println);

    // scribble

    Stream.empty();

    // singleton stream
    Stream.of("one");

    // stream with several elements
    Stream.of("one", "two", "three");

    // generate
    Stream.generate(() -> "one"); // supplier

    Stream.iterate("+", s -> s + "+"); // uniray operator

    ThreadLocalRandom.current().ints(); // random stream

    IntStream streamChar = "hello".chars();

    Path path = null;
    Stream<String> lines = Files.lines(path);

    Stream.Builder<String> builder = Stream.builder();
    builder.add("one").add("two").add("three");

    builder.accept("four");

    Stream<String> stream_1 = builder.build();
    // you cannot call add method now , once it is build
  }

  private static void mapFilterReduce() {

    // print list with people lest than 20 years

    // people.forEach(System.out::println);

    // print age

    people.stream() // Stream<Person>
        .map(p -> p.getAge()) // Stream<Integer>
        .filter(age -> age > 20) // Stream<Integer>
        .forEach(System.out::println);

    people.stream() // Stream<Person>
        .filter(p -> p.getAge() > 20) // Stream<Person>
        .forEach(System.out::println);

    // print intermediate result

    people.stream() // Stream<Person>
        .map(p -> p.getAge()) // Stream<Integer>
        .peek(System.out::println) // logging , not to be used in production
        .filter(age -> age > 20) // Stream<Integer>
        .forEach(System.out::println);

    // peek --> intermediate operation , doesn't trigger stream operation
    // forEach --> terminal operation , which triggers stream operation

    people.stream() // Stream<Person>
        .map(p -> p.getAge()) // Stream<Integer>
        .peek(System.out::println) // logging , not to be used in production
        .filter(age -> age > 20) // Stream<Integer>
        .peek(System.out::println);
  }
}
