package org.functional.concepts;

import java.util.function.Consumer;

//import java.util.function.Consumer;

import org.data.DataGenerator;
import org.data.Person;

public class SimpleConsumerExample implements DataGenerator {
	
	
	
	public static void main(String[] args) {
		
		SimpleConsumer<String> printString = s -> System.out.println(s);
		printString.accept("Hello");
		
		Consumer<Person> printName = p -> System.out.println(p.getName());
		people.forEach(printName);
		
		

		
	}

}
