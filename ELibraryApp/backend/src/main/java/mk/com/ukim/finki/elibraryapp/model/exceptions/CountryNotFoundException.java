package mk.com.ukim.finki.elibraryapp.model.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException() {
        super("Country not found!");
    }
}
