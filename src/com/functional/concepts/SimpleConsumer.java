package com.functional.concepts;

@FunctionalInterface
interface SimpleConsumer<T> {

    void accept(T t);
}