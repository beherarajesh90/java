package com.java.hackerrank;


import java.util.*;
import java.math.*;
import java.security.NoSuchAlgorithmException;
import java.security.*;
import java.nio.charset.StandardCharsets;

public class SHA256Example {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] msgArr = md.digest(str.getBytes(StandardCharsets.UTF_8));
            BigInteger bi = new BigInteger(1, msgArr);
            String hashText = bi.toString(16);
            // System.out.println(hashText.length());
            while(hashText.length()<64){
                hashText = "0" + hashText;
            }
            System.out.println(hashText);
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}