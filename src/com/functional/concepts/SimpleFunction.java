package com.functional.concepts;

@FunctionalInterface
interface SimpleFunction<T, R> {

  R apply(T t);
}
