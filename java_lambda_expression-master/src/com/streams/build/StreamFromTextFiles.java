package com.streams.build;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFromTextFiles {

  public static void main(String[] args) {

    Path path =
        Paths.get(
            "/Users/rahulbhargava/Desktop/git_repo/java/java_lambda_expression/src/org/streams/build/names.txt");

    try (Stream<String> line = Files.lines(path)) {
      // System.out.println(line.count());
      line.forEach(System.out::println);

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    try (var line = Files.lines(path)) {
      // System.out.println(line.count());
      line.forEach(System.out::println);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
