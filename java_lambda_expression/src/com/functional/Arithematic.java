package com.functional;

@FunctionalInterface
public interface Arithematic<T> {

  Integer apply(T t);

  // Cannot define another method as it will throw compilation error
  // public Boolean evaluate(T t);

  default Arithematic<T> add(Arithematic<T> cube) {
    return t -> apply(t) + cube.apply(t);
  }
}
