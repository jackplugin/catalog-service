package org.jack.cloudnative.catalogservice.demo;

import org.jack.cloudnative.catalogservice.domain.Book;
import org.jack.cloudnative.catalogservice.domain.IBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "catalogservice.testdata.enabled",havingValue = "true")
public class TestDataLoader {
    private final IBookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(TestDataLoader.class);
    public TestDataLoader(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        logger.info("Detected that loading test data is required.");
        logger.info("Loading test data is started.");
        bookRepository.addBook(new Book("1212", "Jack Book", "Jack", 12.03));
        logger.info("Loading test data is done.");
    }
}
