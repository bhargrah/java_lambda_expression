package org.collection;

import java.util.ArrayList;
import java.util.Arrays;
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

	private static void removeIf() { // takes predicate

		printerLamda.accept("\nIterating using lamda - \n");

		Consumer<List> personLstInterator = people -> people.forEach(person -> System.out.println(person));
		personLstInterator.accept(people);

		// filter person less than < some years of age
		Predicate<Person> ageFilter = p -> p.getAge() < 18; // readable
		people.removeIf(ageFilter);

		people.removeIf(p -> p.getAge() < 20); // single line , same job

		printerLamda.accept("\nAfter filter  - \n");

		personLstInterator.accept(people);

	}

	private static void replaceAll() {

	}

	private static void sort() {

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
