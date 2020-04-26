package org.functional;

public class Practice {

	public static void main(String[] args) {

		// Practice - Create Arithematic predicate and write few samples

		Arithematic<Integer> square = n -> (n * n);
		Arithematic<Integer> cube = n -> (n * n * n);
		Arithematic<Integer> multBy2 = n -> (n * 2);
		Arithematic<Integer> multBy3 = n -> (n * n);

		System.out.println(square.apply(3));
		System.out.println(multBy2.apply(3));
		System.out.println(multBy3.apply(multBy2.apply(3)));
		
		// Appending two predicate operation 
		Arithematic<Integer> square_plus_cube = square.add(cube);
		
		System.out.println(square_plus_cube.apply(2));
		
	}

}
