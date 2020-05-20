package org.functional;

// user defined Predicate , check actual implementation also in java docs

@FunctionalInterface
public interface Predicate<T> {

    public boolean test(T t);   // see the signature , it returns only boolean
    
    public default Predicate<T> and(Predicate<T> other) {
        return t -> test(t) && other.test(t) ;
    }
    
    public default Predicate<T> or(Predicate<T> other) {
        return t -> test(t) || other.test(t);
    }
    
    public static <U> Predicate<U> isEqualsTo(U u) {
        return s -> s.equals(u);
    }
}
