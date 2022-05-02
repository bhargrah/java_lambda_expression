package com.functional;

@FunctionalInterface
public interface Arithematic<T> {

    public Integer apply(T t);

    // Cannot define another method as it will throw compilation error
    // public Boolean evaluate(T t);

    public default Arithematic<T> add(Arithematic<T> cube) {
        return t -> apply(t) + cube.apply(t);
    }

}
