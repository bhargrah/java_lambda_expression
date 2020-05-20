package org.functional.concepts;

import java.util.function.Predicate;

public class SimplePredicateExample {

	public static void main(String[] args) {
		
		
		// Create a simple predicate		
		SimplePredicate<String> lenGreaterThan4 = s -> s.length() > 4; // creating a method
		System.out.println(lenGreaterThan4.test("heloo")); // passing code
		
		SimplePredicate<Integer> numberEqualTo7 = i -> i.compareTo(7) == 0;
		System.out.println(numberEqualTo7.test(6));
		System.out.println(numberEqualTo7.test(7));
		
		// Method Reference 
		SimplePredicate<String> isEmpty = String::isEmpty;    // this is possible only when methods takes no argument --> public boolean isEmpty() {
		SimplePredicate<String> isBlank = String::isBlank;    // this is possible only when methods takes no argument --> public boolean isBlank() {
		
		System.out.println(isEmpty.test("ui"));
		System.out.println(isBlank.test(""));
		
		// implement equals --> public boolean equals(Object anObject) {
		//SimplePredicate<String> equals = String::equals; --> will give error as we cannot have two arguments
		
		
		// Examples with regular predicates , to show all features 
		
		Predicate<String> p1 = s -> s.length() > 4;
		Predicate<String> p2 = s -> s.length() < 11;
		
		Predicate<String> p3 = p1.and(p2); // chaining two predicate
		
		System.out.println(p3.test("Rahul"));   // and 
		System.out.println(p1.and(p2).test("Rahul"));
		
		Predicate<Integer> ageGtr18 = i -> i.compareTo(18) == 1;
		Predicate<Integer> ageLess45 = i -> i.compareTo(45) == -1;
		
		Predicate<Integer> validaRange = ageGtr18.and(ageLess45);
		System.out.println(validaRange.test(60));
		
		
		Predicate<Character> male = c -> c.compareTo('M') == 0;
		Predicate<Character> female = c -> c.compareTo('F') == 0;
		
		
		Predicate<Character> gender = male.or(female); // or
		
		System.out.println(gender.test('M'));
		System.out.println(gender.test('F'));
		System.out.println(gender.test('A'));
		
		Predicate<Character> others = gender.negate(); // negate , opposite
		
		System.out.println(others.test('A'));
		
		
		

	}

}