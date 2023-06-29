package com.java.hackerrank;

import java.util.*;
import java.util.stream.Collectors;
/*
 * Create the Student and Priorities classes here.
 */

class Student2 implements Comparable<Student2> {

    private int id;
    private String name;
    private double cgpa;

    Student2(int id, String name, double cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student2 o2) {
        if(this.getCgpa()<o2.getCgpa()){
            return 1;
        }else if(this.getCgpa()>o2.getCgpa()){
            return -1;
        }else{
            if(this.getName().equals(o2.getName())){
                return  this.getId()<o2.getId() ? 1 : -1;
            }else{
                return this.getName().compareTo(o2.getName());
            }
        }
    }
}

class Priorities{
    List<Student2> getStudents(List<String> events){
        PriorityQueue<Student2> pq = new PriorityQueue<>();
        for(String s:events){
            String str[] = s.split(" ");
            if(str[0].equals("ENTER")){
                pq.add(new Student2(Integer.valueOf(str[3]),str[1],Double.valueOf(str[2])));
            }else if(str[0].equals("SERVED")){
                pq.poll();
            }
        }
        List<Student2> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
}

public class PriorityQueueExample {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student2> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student2 st : students) {
                System.out.println(st.getName());
            }
        }
    }
}