package com.java.multithreading.streams.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Beher\\Desktop\\Cognizant Training\\FSE1\\java\\programs\\java\\src\\com\\java\\multithreading\\streams\\files\\names.txt";
        Stream<String> names = Files.lines(Path.of(path));
        List<String> namesList = names.collect(Collectors.toList());
        namesList.stream().forEach(System.out::println);
    }
}
