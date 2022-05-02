package com.streams.build;

public class StreamFromString {

  public static void main(String[] args) {

    String sentence = "the quick brown fox jums over the lazy dog";

    String debug = "aaaabbbeeeettsswweesds";

    debug
        .chars()
        .mapToObj(Character::toString) // map integer to actual ascii character
        .filter(letter -> !letter.equals("a")) // remove empty letters
        .distinct()
        .sorted()
        .forEach(System.out::print);
  }
}
