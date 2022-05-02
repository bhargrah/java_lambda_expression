package com.functional.concepts;

public class ComplexConsumerExample<T> {

    public static void main(String[] args) {


        ComplexConsumer<String> consumer = (s1, s2) -> System.out.println(s1 + s2);

        consumer.accept("Rahul", " Bhargava");

    }

}