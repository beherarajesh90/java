package com.java.java8Features.intro;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        /**
         * prior to java 8
         */
        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnable 1");
            }
        };
        new Thread(runnable1).start();

        /**
         * java 8
         */
        Runnable runnable=()->System.out.println("inside runnable 2");
        new Thread(runnable).start();
        /**
         * or
         */
        new Thread(()->System.out.println("inside runnable 3")).start();
//        Map m=new HashMap();
//        m.put("&quot;dssd","dsds");
//        System.out.println(m);
    }

}
