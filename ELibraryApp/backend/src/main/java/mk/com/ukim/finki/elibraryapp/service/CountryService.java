package mk.com.ukim.finki.elibraryapp.service;

import mk.com.ukim.finki.elibraryapp.model.Author;
import mk.com.ukim.finki.elibraryapp.model.Book;
import mk.com.ukim.finki.elibraryapp.model.Country;
import mk.com.ukim.finki.elibraryapp.model.dto.BookDto;
import mk.com.ukim.finki.elibraryapp.model.dto.CountryDto;
import mk.com.ukim.finki.elibraryapp.model.enums.Category;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(String name, String continent);
    Optional<Country> save(CountryDto countryDto);
    Optional<Country> edit(Long id,String name, String continent);
    Optional<Country> edit(Long id,CountryDto countryDto);
    void delete(Long id);
}
