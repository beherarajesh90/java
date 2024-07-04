package com.java.annotation;

public class TestClass {

    @customAnnotation(size = 10)
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.setLength(2);
        System.out.println(t.getLength());
    }
}
