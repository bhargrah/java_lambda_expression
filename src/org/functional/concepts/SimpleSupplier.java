package org.functional.concepts;

@FunctionalInterface
interface SimpleSupplier<T> {
	T get();
}