# Lambdas

* A lambda expression is a method without a name that is used to **pass around behavior** as if it were data.
* Lambda expressions look like this: BinaryOperator<Integer> add = (x, y) → x + y.
* A functional interface is an interface with a single abstract method that is used as the type of a lambda expression.

# Functional Interface

### java.util.funciton

* Consumer -- consumer object and dosen't return anything
* Supplier -- provides an object and take no parameter
* Function -- takes an object and returns another object
* Predicate -- takes an object and returns a boolean

### Cheat Sheet

![](https://github.com/bhargrah/java_lambda_expression/blob/master/src/resources/CheatSheet.png)
![](https://github.com/bhargrah/java_lambda_expression/blob/master/src/resources/function.png)

### Performance

* Lambdas are invoked using invokeDynamics (introduced in java7) , which are very fast
* Make sure to write code while taking care Autoboxing and Unboxing

# Streams

![](https://github.com/bhargrah/java_lambda_expression/blob/master/src/resources/streams.png)

## Repos to Look at

- https://github.com/kousen/java_upgrade
- https://github.com/kousen/java_8_recipes
- https://www.kousenit.com/java8/
