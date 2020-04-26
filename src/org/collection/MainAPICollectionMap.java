package org.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MainAPICollectionMap {

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

	private static void forEach() {

		printerLamda.accept("\nIterating using lamda - \n");
		people.forEach(person -> System.out.println(person)); // lambda

		printerMethod.accept("\nIterating using lamda - \n");
		people.forEach(System.out::println); // method reference

	}

	private static void putIfAbsent(Map<City, List<Person>> map) {

		System.out.println(map.get(paris) == null ? "No entry present for " + paris : "Entry present for " + paris);

		// regular way of adding value , has to be done every time when adding entry in
		// map
		if (map.get(paris) == null) {
			map.put(paris, new ArrayList<>());
			map.get(paris).add(p1);
		} else {
			map.get(paris).add(p1);
		}

		// new putIfAbsent way
		map.putIfAbsent(shanghai, new ArrayList<>());
		map.get(shanghai).add(p3);

		// now adding second value to map will simply add the value to existing list ,
		// will not create new one
		map.putIfAbsent(shanghai, new ArrayList<>());
		map.get(shanghai).add(p3);

		System.out.println("People from Paris : " + map.getOrDefault(paris, Collections.EMPTY_LIST));
		System.out.println("People from Shanghai : " + map.getOrDefault(shanghai, Collections.EMPTY_LIST));
		System.out.println("People from New York : " + map.getOrDefault(newYork, Collections.EMPTY_LIST));
	}

	
	public static void main(String[] args) {

		Map<City, List<Person>> map = new HashMap<>(); // empty map

		// Mimic behavior of putIfAbsent
		 putIfAbsent(map);
		
		System.out.println("\n\n");

		map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
		map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);

		System.out.println("People from Paris : " + map.getOrDefault(paris, Collections.EMPTY_LIST));
		System.out.println("People from New York : " + map.getOrDefault(newYork, Collections.EMPTY_LIST));

		Map<City, List<Person>> map1 = new HashMap<>();
		map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
		map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
		map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);

		System.out.println("Map 1");
		map1.forEach((city, people) -> System.out.println(city + " : " + people));

		Map<City, List<Person>> map2 = new HashMap<>();
		map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
		map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
		map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);

		System.out.println("Map 2");
		map2.forEach((city, people) -> {
			System.out.println(city + " : " + people);
		});

		map2.forEach((city, people) -> {
			map1.merge(city, people, (peopleFromMap1, peopleFromMap2) -> {
				peopleFromMap1.addAll(peopleFromMap2);
				return peopleFromMap1;
			});
		});

		System.out.println("Merged map1 ");
		map1.forEach((city, people) -> System.out.println(city + " : " + people));

		System.out.println("map2 (unchanged)");
		map2.forEach((city, people) -> System.out.println(city + " : " + people));
	}

}
