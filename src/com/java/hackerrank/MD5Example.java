package com.java.hackerrank;

import java.util.*;
import java.security.*;
//import javax.xml.bind.DatatypeConverter;


public class MD5Example {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scan = new Scanner(System.in);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(scan.nextLine().getBytes());
//        System.out.print(DatatypeConverter.printHexBinary(md.digest()).toLowerCase());
        scan.close();

    }
}
