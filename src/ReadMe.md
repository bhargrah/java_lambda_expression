# Java 8 has functional interface defined

## java.util.funciton

### Consumer -- consumer object and dosen't return anything

### Supplier -- provides an object and take no parameter

### Function -- takes an object and returns another object

### Predicate -- takes an object and returns a boolean

for primitive types

- IntPredicate
- IntFunction

boolean forEach(Consumer<? super E> consumer)

boolean forEach(BiConsumer<? super E> consumer) -- map , because key/value pair

boolean removeIf(Predicate<? super E> filter)

Map -
V getOrDefault(Object key , V defaultValue);

# Google Java Code Formatting Plugin 
https://plugins.jetbrains.com/plugin/8527-google-java-format/versions