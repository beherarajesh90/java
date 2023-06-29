package com.java.multithreading.streams.customObjects;

import java.util.*;
import java.util.stream.Collectors;

public class App4 {

	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
		books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
		books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
		books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
		books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
		books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
		books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

		// map() and flatMap() are similar to selecting a column in SQL
		// transform the original values
		// number of characters in every word
		List<String> b = books.stream().filter(book->book.getType()==Type.NOVEL)
				.sorted(Comparator.comparing(Book::getPages,Comparator.reverseOrder()))
				.map(book->book.getTitle())
				.collect(Collectors.toList());

//		b.stream().forEach(System.out::println);

//		Map<Type,List<Book>> groupByType = books.stream().collect(Collectors.groupingBy(Book::getType));
//		groupByType.entrySet().forEach(System.out::println);

//		List<String> longestTwoBooks = books.stream().filter(book->book.getPages()>500)
//				.map(book->book.getTitle()).limit(2).collect(Collectors.toList());
//
//		longestTwoBooks.stream().forEach(System.out::println);

		books.stream().filter(book->book.getTitle().split(" ").length==2)
				.forEach(System.out::println);

	}

}
