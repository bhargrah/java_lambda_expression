package com.map_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class MainReduction {

    public static final Consumer<String> printer = s -> System.out.println(s);

    public static int reduce(List<Integer> values, int valueIfEmpty, BinaryOperator<Integer> reduction) {

        int result = valueIfEmpty;
        for (int value : values) {
            result = reduction.apply(result, value);
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, -1, -2, -3, -4);

        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(-1, -2, -3, -4);


        BinaryOperator<Integer> add = (i1, i2) -> (i1 + i2);

        // simulating parallel call
        int add1 = reduce(ints1, 0, add); // suppose one thread
        int add2 = reduce(ints2, 0, add); // suppose second thread
        int add_prallel = reduce(Arrays.asList(add1, add2), 0, add); // merge

        // serial non parallel
        int add_serial = reduce(ints, 0, add); // merge

        printer.accept("Add - Reduction (Paralle)  : " + add_prallel);
        printer.accept("Add - Reduction (Serial)  : " + add_serial);


        // more analysis needs to be done
        BinaryOperator<Integer> max = (i1, i2) -> Integer.max(i1, i2); // operation should be associative
        // simulating parallel call
        int reduction1 = reduce(ints1, 0, add); // suppose one thread
        int reduction2 = reduce(ints2, 0, add); // suppose second thread
        int reduction_prallel = reduce(Arrays.asList(reduction1, reduction2), 0, add); // merge

        // serial non parallel
        int reduction_serial = reduce(ints, 0, max); // merge

        printer.accept("Max - Reduction (Paralle)  : " + reduction_prallel);
        printer.accept("Max - Reduction (Serial)  : " + reduction_serial);


        // simulate subtraction steps

        // simulate min step or any other non associative operation


    }
}

