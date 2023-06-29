package com.java.java11Features;

public class LambdaExpressionParameters {
    public static void main(String[] args) {
        //var(same as var in javascript)
        DemoInterface di = (var a, var b) -> a+b;
        System.out.println(di.operation(1,2));
    }
}
interface DemoInterface{
    int operation(int a,int b);
}