package com.java.multithreading.streams.parallelization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App3 {

    public static final String DIRECTORY = System.getProperty("users.dir")+"/test/";

    public static void main(String[] args) throws IOException {
        //create directory
        Files.createDirectories(Paths.get(DIRECTORY));
        App3 app = new App3();
        List<Person> list = app.generatePersons(100000);
        // sequential algorithm
        long start = System.currentTimeMillis();
        list.stream().forEach(App3::save);
        System.out.println("Time taken sequential: " + (System.currentTimeMillis() - start));

        // parallel algorithm
        start = System.currentTimeMillis();
        list.parallelStream().forEach(App3::save);
        System.out.println("Time taken parallel: " + (System.currentTimeMillis() - start));
    }

    public static void save(Person person){
        try(FileOutputStream fos = new FileOutputStream(new File(DIRECTORY+person.getId()+".txt"))){
            fos.write(person.getId());
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<Person> generatePersons(int nums){
        return Stream.iterate(0,n->n+1)
                .limit(nums)
                .map(id->new Person(id))
                .collect(Collectors.toList());
    }
}
