package org.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntStreamOps {
	
	public static void main(String[] args) {
		

		
		int [] numbers = IntStream.range(78, 1000).toArray();
		System.err.println(Arrays.toString(numbers));
		
		
		
		int min = IntStream.of(numbers).min().orElse(-1);
		System.err.println(min);
		
		
		IntSummaryStatistics summary = IntStream.of(numbers).summaryStatistics();
		System.out.println(summary.getSum());
		System.out.println(summary.getCount());
		System.out.println(summary.getMax());
		System.out.println(summary.getMin());
		
		
		IntStream.of(numbers)
		         .distinct()
		         .sorted()
		         .limit(3)
		         .forEach(System.out::println);
		
		
		// Find all even number 
		// Find all odd number
		// Total distinct number
		// Top 3 max 
		// Bottom 3 lowest number
		// 
		
		
	}

}
