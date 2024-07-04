package com.java.multithreading.streams.customObjects;

import java.util.ArrayList;
import java.util.List;

public class OptionalsExample {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

//        System.out.println(books.stream().count());

//        Optional<Integer> b = books.stream().map(Book::getPages).reduce(Integer::max);
//        b.ifPresent(System.out::println);

//        Optional<Book> book = books.stream().reduce((b1,b2)->b1.getPages()>b2.getPages()?b1:b2);
//        book.ifPresent(System.out::println);

//        int totalPages = books.stream().mapToInt(Book::getPages).sum();
//        System.out.println(totalPages);

        //        int stream to stream of int
//        IntStream intStream = books.stream().mapToInt(Book::getPages);
//        Stream<Integer> stream = intStream.boxed();

//        same for optionalLong and optionalDouble
//        OptionalInt optionalInt = books.stream().mapToInt(Book::getPages).max();
//        System.out.println(optionalInt.orElse(0));

//        boolean res  = books.stream().allMatch(book->book.getPages()>2000);
//        boolean res  = books.stream().noneMatch(book->book.getPages()>2000);
//        System.out.println(res);
        books.stream().filter(book->book.getType()==Type.NOVEL).findAny().ifPresent(System.out::println);
        books.stream().filter(book->book.getType()==Type.NOVEL).findFirst().ifPresent(System.out::println);
    }
}
