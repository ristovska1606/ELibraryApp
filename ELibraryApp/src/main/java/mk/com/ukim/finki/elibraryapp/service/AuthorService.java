package mk.com.ukim.finki.elibraryapp.service;

import mk.com.ukim.finki.elibraryapp.model.Author;
import mk.com.ukim.finki.elibraryapp.model.Country;
import mk.com.ukim.finki.elibraryapp.model.dto.AuthorDto;
import mk.com.ukim.finki.elibraryapp.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(String name, String surname, Long countryId);
    Optional<Author> save(AuthorDto authorDto);
    Optional<Author> edit(Long id,String name, String surname, Long countryId);
    Optional<Author> edit(Long id, AuthorDto authorDto);
    void delete(Long id);
}
