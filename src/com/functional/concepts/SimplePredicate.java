package com.functional.concepts;

@FunctionalInterface
interface SimplePredicate<T> {

    boolean test(T t);
}