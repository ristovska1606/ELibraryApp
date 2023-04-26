package mk.com.ukim.finki.elibraryapp.service.impl;

import mk.com.ukim.finki.elibraryapp.model.Author;
import mk.com.ukim.finki.elibraryapp.model.Country;
import mk.com.ukim.finki.elibraryapp.model.dto.AuthorDto;
import mk.com.ukim.finki.elibraryapp.model.exceptions.AuthorNotFoundException;
import mk.com.ukim.finki.elibraryapp.model.exceptions.CountryNotFoundException;
import mk.com.ukim.finki.elibraryapp.repository.AuthorRepository;
import mk.com.ukim.finki.elibraryapp.repository.CountryRepository;
import mk.com.ukim.finki.elibraryapp.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of(this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException()));
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException());
        Author author = new Author(name, surname, country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountry()).orElseThrow(() -> new CountryNotFoundException());

        this.authorRepository.deleteAuthorByName(authorDto.getName());

        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
        this.authorRepository.save(author);

        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException());

        author.setName(name);
        author.setSurname(surname);
        Country country = this.countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException());
        author.setCountry(country);

        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException());

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        Country country = this.countryRepository.findById(authorDto.getCountry()).orElseThrow(() -> new CountryNotFoundException());
        author.setCountry(country);

        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void delete(Long id) {
        this.authorRepository.deleteById(id);
    }
}
