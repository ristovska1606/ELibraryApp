package mk.com.ukim.finki.elibraryapp.repository;

import mk.com.ukim.finki.elibraryapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
