package org.functional.concepts;

@FunctionalInterface
interface SimpleConsumer<T> {
	void accept(T t);
}