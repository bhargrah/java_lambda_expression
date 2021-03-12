package org.streams.build;

public class StreamFromString {

	public static void main(String[] args) {

		String sentence = "the quick brown fox jums over the lazy dog";
		
		sentence.chars()
		        .mapToObj(code -> Character.toString(code)) // map integer to actual ascii character
		        .filter(letter -> !letter.equals(" ")) // remove empty letters
		        .distinct()
		        .sorted()
		        .forEach(System.out::print);

		
	}

}
