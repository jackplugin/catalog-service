package org.jack.cloudnative.catalogservice.domain;

import java.util.Optional;

public interface IBookRepository {
    Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    Book addBook(Book book);
}
