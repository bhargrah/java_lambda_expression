package com.primitive;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;

public class PrimitiveLambdas {

  public static void main(String[] args) {

    IntSupplier intSup = () -> 10;
    var result = intSup.getAsInt();
    System.out.println(result);

    // use primitive type to boost up performance if collection size is too big
    DoubleToIntFunction circleCircumference = (radius) -> (int) (Math.PI * radius * radius);
    System.out.println(circleCircumference.applyAsInt(3.0));
  }
}
