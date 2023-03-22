package mk.com.ukim.finki.elibraryapp.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException() {
        super("Author not found!");
    }
}
