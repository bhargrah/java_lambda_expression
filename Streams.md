## map

* map lets you apply  function to a stream of values, producing another stream of the new values.

![image](https://user-images.githubusercontent.com/15336266/116804422-45a8a600-ab3c-11eb-9819-96cd70acda5a.png)

## filter 

![image](https://user-images.githubusercontent.com/15336266/116804442-77ba0800-ab3c-11eb-8ca1-44f57bd73e2a.png)


## flatMap
* Lets you replace a value with a Stream and concatenates all the streams together.

![image](https://user-images.githubusercontent.com/15336266/116804451-8dc7c880-ab3c-11eb-9374-1f980de828cb.png)

``` java
List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                               .flatMap(numbers -> numbers.stream())
                               .collect(toList());
assertEquals(asList(1, 2, 3, 4), together);
```
