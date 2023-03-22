package mk.com.ukim.finki.elibraryapp.service;

import mk.com.ukim.finki.elibraryapp.model.User;
import mk.com.ukim.finki.elibraryapp.model.enums.Role;

public interface UserService{
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
