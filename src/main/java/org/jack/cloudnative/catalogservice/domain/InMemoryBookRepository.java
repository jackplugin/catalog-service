package org.jack.cloudnative.catalogservice.domain;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBookRepository implements IBookRepository{
    private static final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        var book = books.get(isbn);
        return book != null ? Optional.of(book) : Optional.empty();
    }

    @Override
    public Book addBook(Book book) {
        books.put(book.isbn(), book);
        return book;
    }
}
