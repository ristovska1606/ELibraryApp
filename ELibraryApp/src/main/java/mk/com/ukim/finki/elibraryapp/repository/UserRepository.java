package mk.com.ukim.finki.elibraryapp.repository;

import mk.com.ukim.finki.elibraryapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
