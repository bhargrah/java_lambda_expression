package com.streams.build;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamFromRegularExpression {

  public static void main(String[] args) {

    String sentence = "the quick brown fox jums over the lazy dog";

    // should not be used as it keeps intermediate result in memory
    String[] words = sentence.split(" ");
    Stream<String> stream = Stream.of(words);
    System.out.println("Total words (not optimize) : " + stream.count());

    // correct way if using streams
    Pattern pattern = Pattern.compile(" ");
    long count = pattern.splitAsStream(sentence).count();
    System.out.println("Total words (optimize): " + count);
  }
}
