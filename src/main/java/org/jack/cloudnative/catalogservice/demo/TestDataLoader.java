package org.jack.cloudnative.catalogservice.demo;

import org.jack.cloudnative.catalogservice.domain.Book;
import org.jack.cloudnative.catalogservice.domain.IBookRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "catalogservice.testdata.enabled",havingValue = "true")
public class TestDataLoader {
    private final IBookRepository bookRepository;

    public TestDataLoader(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.addBook(new Book("1212", "Jack Book", "Jack", 12.03));
    }
}
