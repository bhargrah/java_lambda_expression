package com.functional;

// user defined Predicate , check actual implementation also in java docs

@FunctionalInterface
public interface Predicate<T> {

  static <U> Predicate<U> isEqualsTo(U u) {
    return s -> s.equals(u);
  }

  boolean test(T t); // see the signature , it returns only boolean

  default Predicate<T> and(Predicate<T> other) {
    return t -> test(t) && other.test(t);
  }

  default Predicate<T> or(Predicate<T> other) {
    return t -> test(t) || other.test(t);
  }
}
