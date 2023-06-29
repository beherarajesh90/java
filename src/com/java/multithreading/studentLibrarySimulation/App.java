package com.java.multithreading.studentLibrarySimulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Book[] books = null;
        Student[] students=null;
        ExecutorService service = Executors.newFixedThreadPool(Constants.NO_OF_STUDENTS);

        try {
            books = new Book[Constants.NO_OF_BOOKS];
            students = new Student[Constants.NO_OF_STUDENTS];

            for(int i=0;i<Constants.NO_OF_BOOKS;i++){
                books[i]=new Book(i+1);
            }

            for(int i=0;i<Constants.NO_OF_STUDENTS;i++){
                students[i] = new Student(i+1,books);
                service.execute(students[i]);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }
}
