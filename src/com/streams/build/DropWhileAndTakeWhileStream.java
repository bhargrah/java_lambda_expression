package com.streams.build;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DropWhileAndTakeWhileStream {

    public static void main(String[] args) {

        Path path = Paths.get("/Users/rahulbhargava/Desktop/git_repo/java/java_lambda_expression/src/org/streams/build/names.txt");

        try (Stream<String> lines = Files.lines(path)) {

            lines.dropWhile(letter -> letter.startsWith("r"));
            //.forEach(System.out::println);


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (Stream<String> lines = Files.lines(path)) {

            lines.takeWhile(letter -> letter.startsWith("r")) // stop the stream if match is found
                    .forEach(System.out::println);


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
