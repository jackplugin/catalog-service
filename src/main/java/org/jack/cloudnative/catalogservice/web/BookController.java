package org.jack.cloudnative.catalogservice.web;

import jakarta.validation.Valid;
import org.jack.cloudnative.catalogservice.config.CatalogServiceProperties;
import org.jack.cloudnative.catalogservice.domain.Book;
import org.jack.cloudnative.catalogservice.domain.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookService bookService;
    private final CatalogServiceProperties catalogServiceProperties;

    public BookController(BookService bookService, CatalogServiceProperties catalogServiceProperties) {
        this.bookService = bookService;
        this.catalogServiceProperties = catalogServiceProperties;
    }

    @GetMapping("/")
    public String hello() {
        return catalogServiceProperties.getGreeting();
    }

    @GetMapping("/books")
    public Iterable<Book> get() {
        var content = """
                {
                "isbn": "1234567890",
                "title": "Title",
                "author": "Author",
                "price": 9. 90
                }
                """;
        return bookService.findAll();
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }
}
