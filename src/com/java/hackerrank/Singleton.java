package com.java.hackerrank;

class SingletonExample {

    public String str;
    private static SingletonExample INSTANCE;

    private SingletonExample() {}

    public static SingletonExample getSingleInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized(SingletonExample.class) {
            if (INSTANCE != null) {
                return INSTANCE;
            }
            INSTANCE = new SingletonExample();
            return INSTANCE;
        }
    }
}

public class Singleton {
    public static void main(String[] args) {

    }
}