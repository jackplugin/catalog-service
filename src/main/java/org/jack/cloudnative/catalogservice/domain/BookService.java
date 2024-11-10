package org.jack.cloudnative.catalogservice.domain;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final InMemoryBookRepository inMemoryBookRepository;

    public BookService(InMemoryBookRepository inMemoryBookRepository) {
        this.inMemoryBookRepository = inMemoryBookRepository;
    }

    public Iterable<Book> findAll() {
        return inMemoryBookRepository.findAll();
    }

    public Book addBook(Book book) {
        var existingBook = this.inMemoryBookRepository.findByIsbn(book.isbn());
        if (existingBook.isPresent()){
            throw new BookAlreadyExistsException(book.isbn());
        }
        return inMemoryBookRepository.addBook(book);
    }
}
