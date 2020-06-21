package org.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DataGenerator {
	
	public static Person p1 = new Person("Alice", 23);
	public static Person p2 = new Person("Brian", 56);
	public static Person p3 = new Person("Chelsea", 46);
	public static Person p4 = new Person("David", 28);
	public static Person p5 = new Person("Erica", 37);
	public static Person p6 = new Person("Francisco", 18);
	public static Person p7 = new Person("Tom", 16);
	public static Person p8 = new Person("Start", 21);
	public static Person p9 = new Person("Hank", 18);

	public static City newYork = new City("New York");
	public static City shanghai = new City("Shanghai");
	public static City paris = new City("Paris");
 
	public static List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
	

}
