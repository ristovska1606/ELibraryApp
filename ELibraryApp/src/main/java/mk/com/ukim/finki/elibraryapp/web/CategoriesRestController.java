package mk.com.ukim.finki.elibraryapp.web;

import mk.com.ukim.finki.elibraryapp.model.Book;
import mk.com.ukim.finki.elibraryapp.model.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesRestController {

    @GetMapping
    public List<String> findAll(){
        return Arrays.stream(Category.values()).map(i -> i.name()).collect(Collectors.toList());
    }
}
