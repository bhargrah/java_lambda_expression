package com.functional.concepts;

import java.util.function.Function;

public class SimpleFunctionExample {

    public static void main(String[] args) {

        SimpleFunction<Integer, Integer> square = i -> i * i;
        SimpleFunction<Integer, Integer> cube = i -> i * i * i;
        SimpleFunction<Integer, Double> squareRoot = i -> Math.sqrt(i);

        out(square.apply(2));
        out(cube.apply(2));
        out(squareRoot.apply(9).intValue());

        // Method reference
        Function<Double, Double> log10 = Math::log10;
        Function<Double, Double> sqrt = Math::sqrt;
        Function<Double, Double> log = Math::log;
        Function<Double, Double> floor = Math::floor;

        out(log10.apply(10.00));
        out(sqrt.apply(9.00));
        out(log.apply(2.00));
        out(floor.apply(10.456456));

        // Method Usage
        Function<Double, Double> cube1 = i -> i * i * i;

        calculator(Math::sqrt, 10.00);  // method reference
        calculator(i -> i + i, 10.00);  // lambda
        calculator(cube1, 10.00);       // user defined

        Function<String, Integer> length = s -> s.length();
        out(length.apply("Rahul"));

    }

    public static void calculator(Function<Double, Double> object, Double data) {
        out(object.apply(data));
    }

    public static void out(Object object) {
        System.out.println(object);
    }

}