package org.streams.build;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.data.Person;

public class StreamsFromArray {

	public static Person p1 = new Person("Alice", 23);
	public static Person p2 = new Person("Brian", 56);
	public static Person p3 = new Person("Chelsea", 46);
	public static Person p4 = new Person("David", 28);
	public static Person p5 = new Person("Erica", 37);
	public static Person p6 = new Person("Francisco", 18);
	public static Person p7 = new Person("Tom", 16);
	public static Person p8 = new Person("Start", 21);
	public static Person p9 = new Person("Hank", 18);

	public static void main(String[] args) {

		// Create stream from simple people array
		Person[] people = { p1, p2, p3, p4, p5, p6, p7, p8, p9 };
		long count = Stream.of(people).count(); 
		System.out.println("People Count : " + count);


		// Stream of strings
		String[] names = { "rahul", "kanu", "miru", "ish", "jen", "sonal", "rahul" };
		System.out.println(Stream.of(names).distinct().count());

		// Stream of int
		int[] numbers = { 1, 2, 3, 4, 56, 78, 4, 2, 87, 2, 3, 4, 6, 6, 6, 6, 6 };
		System.out.println("Average : " + IntStream.of(numbers).average());
		System.out.println("Sum : " + IntStream.of(numbers).sum());
		System.out.println("Distinct : " + IntStream.of(numbers).distinct().count());
		System.out.println("Count : " + IntStream.of(numbers).count());
		
		// creating stream using array
		Arrays.stream(people).forEach(p -> System.out.println(p.getName()));

	}

}
