package mk.com.ukim.finki.elibraryapp.model.exceptions;

public class ZeroAvailableCopiesException extends RuntimeException{
    public ZeroAvailableCopiesException() {
        super("The number of available copies is zero!");
    }
}
