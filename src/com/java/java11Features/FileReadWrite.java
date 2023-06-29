package com.java.java11Features;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileReadWrite {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Beher\\Desktop\\Cognizant Training\\FSE1\\java\\programs\\java\\src\\com\\java\\java11Features\\file.txt";

//        Files.writeString(Path.of(path),"hi there", StandardOpenOption.APPEND);

        String data = Files.readString(Path.of(path));
        System.out.println(data);
    }
}
