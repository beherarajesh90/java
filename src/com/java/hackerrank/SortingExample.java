package com.java.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class SortingExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        List<Student> resList = studentList.stream().sorted((o1, o2) -> {
            if (o1.getCgpa() < o2.getCgpa()) {
                return 1;
            } else if (o1.getCgpa() > o2.getCgpa()) {
                return -1;
            } else {
                if (o1.getFname().equals(o2.getFname())) {
                    if (o1.getId() < o2.getId()) {
                        return -1;
                    }
                    return 1;
                }
                return o1.getFname().compareTo(o2.getFname());

            }
        }).collect(Collectors.toList());

        for (Student st : resList) {
            System.out.println(st.getFname());
        }
    }
}

//alternate solution

//class bruh implements Comparator {
//    public int compare(Student a, Student b) {
//        if (a.getCgpa() b.getCgpa()){
//            return -1;
//        }else{
//            return a.getFname().compareTo(b.getFname());
//        }
//    }
//
//} //Complete the code public class Solution {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int testCases = Integer.parseInt(in.nextLine());
//
//        List<Student> studentList = new ArrayList<Student>();
//        while (testCases > 0) {
//            int id = in.nextInt();
//            String fname = in.next();
//            double cgpa = in.nextDouble();
//
//            Student st = new Student(id, fname, cgpa);
//            studentList.add(st);
//
//            testCases--;
//        }
//        Comparator<Student> lol = new bruh();
//        studentList.sort(lol);
//        for (Student st : studentList) {
//            System.out.println(st.getFname());
//        }
//    }
//}

