package com.example.springmongodb.repository;

import com.example.springmongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.stream.Stream;

public interface BookRespository extends MongoRepository <Book,Integer>{

    @Query("{bookName : ?0}")
    Book findBookByName(String id);

    @Query("{bookName : ?0, authorName : ?1}")
    Stream<Book> findBooksByWriterAndCategory(String book, String authorName);

    @Query("{noOfPages:{$gt:?0}}")
    Stream<Book> findBookGreaterThan(int pages);

    @Query("{noOfPages:{$lt:?0}}")
    Stream<Book> findBookLessThan(int pages);

    @Query(value = "{bookName : ?0}", fields = "{ 'authorName' : 1, 'noOfPages' : 1}")
    Stream<Book> findBooksWithCertainFields(String book);
}
