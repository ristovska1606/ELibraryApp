package mk.com.ukim.finki.elibraryapp.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super("Book not found!");
    }
}
