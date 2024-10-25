package org.jack.cloudnative.catalogservice.domain;

public interface IBookRepository {
    Iterable<Book> findAll();

    Book addBook(Book book);
}
