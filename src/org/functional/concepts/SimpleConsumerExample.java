package org.functional.concepts;

public class SimpleConsumerExample {
	
	public static void main(String[] args) {
		
		
		SimpleConsumer<String> print = s -> System.out.print(s);		
		print.accept("Hello");
		

		
	}

}
