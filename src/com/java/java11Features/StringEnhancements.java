package com.java.java11Features;

import java.util.List;
import java.util.stream.Collectors;

public class StringEnhancements {
    public static void main(String[] args) {
        String s1 = "   ";
        System.out.println(s1.isBlank());

        String s2 = "Welcome\nMy name is Rajesh\nI am a Java Dev";
        s2.lines().forEach(System.out::println);
        List<String> list = s2.lines().collect(Collectors.toList());
        System.out.println(list);

        String s3 = "  JAAVVVAAA  ";
        System.out.println(s3.strip());
        System.out.println(s3.stripLeading());
        System.out.println(s3.stripTrailing());

        System.out.println(s3.stripLeading().repeat(10));
    }
}
