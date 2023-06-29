package com.java.java11Features;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional optional = Optional.of("");
        optional = optional.empty();
        System.out.println(optional.isEmpty());
    }
}
