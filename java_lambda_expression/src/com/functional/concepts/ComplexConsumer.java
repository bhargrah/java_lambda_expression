package com.functional.concepts;

@FunctionalInterface
interface ComplexConsumer<T> {

  void accept(T t1, T t2);
}
