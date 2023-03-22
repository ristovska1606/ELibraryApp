package mk.com.ukim.finki.elibraryapp.service;

import mk.com.ukim.finki.elibraryapp.model.Author;
import mk.com.ukim.finki.elibraryapp.model.Book;
import mk.com.ukim.finki.elibraryapp.model.dto.BookDto;
import mk.com.ukim.finki.elibraryapp.model.enums.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(String name, Category category, Author author, Integer availableCopies);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id,String name, Category category, Author author, Integer availableCopies);
    Optional<Book> edit(Long id,BookDto bookDto);
    void delete(Long id);
    Optional<Book> findBookByAuthor(Long authorId);


}