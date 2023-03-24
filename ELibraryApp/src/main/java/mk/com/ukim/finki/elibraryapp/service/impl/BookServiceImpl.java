package mk.com.ukim.finki.elibraryapp.service.impl;

import mk.com.ukim.finki.elibraryapp.model.Author;
import mk.com.ukim.finki.elibraryapp.model.Book;
import mk.com.ukim.finki.elibraryapp.model.Country;
import mk.com.ukim.finki.elibraryapp.model.dto.BookDto;
import mk.com.ukim.finki.elibraryapp.model.enums.Category;
import mk.com.ukim.finki.elibraryapp.model.exceptions.AuthorNotFoundException;
import mk.com.ukim.finki.elibraryapp.model.exceptions.BookNotFoundException;
import mk.com.ukim.finki.elibraryapp.model.exceptions.ZeroAvailableCopiesException;
import mk.com.ukim.finki.elibraryapp.repository.AuthorRepository;
import mk.com.ukim.finki.elibraryapp.repository.BookRepository;
import mk.com.ukim.finki.elibraryapp.repository.CountryRepository;
import mk.com.ukim.finki.elibraryapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.of(this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException()));
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException());
        Book book = new Book(name, category, author, availableCopies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor().getId()).orElseThrow(() -> new AuthorNotFoundException());
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException());
        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        Author author = this.authorRepository.findById(bookDto.getAuthor().getId()).orElseThrow(() -> new AuthorNotFoundException());
        book.setName(bookDto.getName());
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByAuthor(Long authorId) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException());
        return this.bookRepository.findBooksByAuthor(author);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        int availableCopies = book.getAvailableCopies();
        if(availableCopies == 0)
            throw new ZeroAvailableCopiesException();
        book.setAvailableCopies(availableCopies-1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
