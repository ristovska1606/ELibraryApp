package mk.com.ukim.finki.elibraryapp.model.dto;

import lombok.Data;
import mk.com.ukim.finki.elibraryapp.model.Author;
import mk.com.ukim.finki.elibraryapp.model.enums.Category;

@Data
public class BookDto {
    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
