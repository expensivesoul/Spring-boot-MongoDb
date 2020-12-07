package com.example.springmongodb.contoller;

import com.example.springmongodb.model.Book;
import com.example.springmongodb.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class BookController {

    @Autowired
    private BookRespository bookRespository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        bookRespository.save(book);
        return "Added book with id->" + book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBook() {
        return bookRespository.findAll();
    }

    @GetMapping("/findBookByName/{name}")
    public Book gethellp(@PathVariable String name) {
        return bookRespository.findBookByName(name);

    }

    @GetMapping("/findBookByName/{name}/{aname}")
    public Stream<Book> gethellp(@PathVariable String name, @PathVariable String aname) {

        System.out.println(name + aname);
        return bookRespository.findBooksByWriterAndCategory(name, aname);
    }

    @GetMapping("/findBookPagegreaterthan/{page}")
    public Stream<Book> getGreaterpage(@PathVariable int page) {

        return bookRespository.findBookGreaterThan(page);
    }

    @GetMapping("/findBookPageLessthan/{page}")
    public Stream<Book> getLessThanpage(@PathVariable int page) {

        return bookRespository.findBookLessThan(page);
    }

    @GetMapping("/findBookWithCertainfields/{book}")
    public Stream<Book> BookWithCertainfields(@PathVariable String book) {
        return bookRespository.findBooksWithCertainFields(book);
    }

    @GetMapping("/findBookByID/{id}")
    public Optional<Book> findBookbyId(@PathVariable int id) {
        return bookRespository.findById(id);
    }


    @DeleteMapping("/deleteBookByID/{id}")
    public String getBook(@PathVariable int id) {
        bookRespository.deleteById(id);
        return "Book deleted with id:->" + id;
    }

}
