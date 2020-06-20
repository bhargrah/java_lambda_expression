package org.functional.concepts;

public class SimpleSupplierExample<T> {

	public static void main(String[] args) {
		
		SimpleSupplier<String> supplier = () -> "Hello Lambda!!";
		
		String sample = supplier.get();
		System.out.println(sample);
		
	}

}