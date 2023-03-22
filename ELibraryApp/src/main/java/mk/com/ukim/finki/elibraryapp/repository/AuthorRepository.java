package mk.com.ukim.finki.elibraryapp.repository;

import mk.com.ukim.finki.elibraryapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
