package org.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

import org.data.Person;

public class MainComparator {

	@SuppressWarnings("unused")
	public static void main(String... args) {

		Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();   // leveraging compare method 
		Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()); // leveraging compare method 
		Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()); // leveraging compare method 

		Function<Person, Integer> f1 = p -> p.getAge();
		Function<Person, String> f2 = p -> p.getLastName();
		Function<Person, String> f3 = p -> p.getFirstName();

		Function<Person, Integer> f11 = Person::getAge;
		
		
		
		Function<Person, Integer> f_lambda = p -> p.getAge();
		Function<Person, Integer> f_method_refrence = Person::getAge;
		
		// Comparator<Person> cmpPersonAge_v1 = Comparator.comparing(f_lambda);
		// Comparator<Person> cmpPersonAge_v2 = Comparator.comparing(f_method_refrence);
		
		Comparator<Person> cmpPersonAge_v3 = Comparator.comparing(Person::getAge);
		Comparator<Person> cmpPersonAge_v4 = Comparator.comparing(p -> p.getAge());


		
		Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
		Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);

		
		// Chaining comparators 
		Comparator<Person> cmp = Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName).thenComparing(Person::getAge);
		
		
		BinaryOperator<Integer> sub = (i1,i2) -> i1 - i2;
		BinaryOperator<Integer> sum = (i1,i2)-> Integer.sum(i1,i2);
		BinaryOperator<Integer> max = Math::max;
		
		
		Consumer<String> printer = s -> System.out.println(s);
		Consumer<String> printer1 = System.out::println;
		
		
		List<Person> personList = createTestData();
		//Collections.sort(personList,cmpAge);
		System.out.println((personList));
		java.util.Comparator<Person> cmpAgeLocal = (p1,p2) -> p2.getAge() - p1.getAge(); 
		Collections.sort(personList, cmpAgeLocal);
		System.out.println((personList));

		
	}
	
	public static List<Person> createTestData(){
		
		List<Person> personList = new ArrayList<>();
		
		Person rahul = new Person("Rahul","Bhargava",35);
		Person kanu = new Person("Kanu","Bhargava",33);
		Person sonal = new Person("Sonal","Agarwal",33);
		Person idu = new Person("Idu","Agarwal",4);
		Person miraya = new Person("Miraya","Bhargava",2);
		
		personList.add(miraya);
		personList.add(kanu);
		personList.add(sonal);
		personList.add(idu);
		personList.add(rahul);
		
		
		
		return personList;
		
		
	}
	
}
