package mk.com.ukim.finki.elibraryapp.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.com.ukim.finki.elibraryapp.model.enums.Role;

@Entity
@Data
@Table(name = "library_users")
public class User {

    @Id
    private String username;

    @Version
    private Long version;

    private String name;

    private String surname;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String username, String name, String surname, String password, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }
}
