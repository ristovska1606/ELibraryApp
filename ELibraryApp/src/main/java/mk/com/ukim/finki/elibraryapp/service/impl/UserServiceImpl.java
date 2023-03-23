package mk.com.ukim.finki.elibraryapp.service.impl;

import mk.com.ukim.finki.elibraryapp.model.User;
import mk.com.ukim.finki.elibraryapp.model.enums.Role;
import mk.com.ukim.finki.elibraryapp.model.exceptions.InvalidUsernameOrPasswordException;
import mk.com.ukim.finki.elibraryapp.model.exceptions.PasswordsDoNotMatchException;
import mk.com.ukim.finki.elibraryapp.model.exceptions.UsernameAlreadyExistsException;
import mk.com.ukim.finki.elibraryapp.repository.UserRepository;
import mk.com.ukim.finki.elibraryapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,password,name,surname,role);
        return userRepository.save(user);
    }
}
