package mk.com.ukim.finki.elibraryapp.model.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found!");
    }
}
