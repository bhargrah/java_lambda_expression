package com.streams.build;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SkipAndLimitStream {

    public static void main(String[] args) {

        Path path = Paths.get("/Users/rahulbhargava/Desktop/git_repo/java/java_lambda_expression/src/org/streams/build/names.txt");


        try (Stream<String> lines = Files.lines(path)) {


            //lines.forEach(System.out::println); // header gets printed

            //lines.skip(1).forEach(System.out::println); // this will skip the header

            lines.skip(1).limit(2).forEach(System.out::println); // terminate the string after processing 2 records

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
