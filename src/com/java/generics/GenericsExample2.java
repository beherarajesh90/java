package com.java.generics;

class GenericsExample2
{
    public static < E > void printArray( E[] inputArray )
    {
        for ( E element : inputArray ){
            System.out.printf( "%s\n", element );
        }
    }

    public static void main(String[] args) {
        Integer[] arr1= {1,2,3};     //int float double types are not used with generics
        String[] arr2 = {"sf","faded"};
        printArray(arr1);
        printArray(arr2);
    }

}