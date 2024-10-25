package org.jack.cloudnative.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;

public record Book(
        @NotBlank(message = "The book ISBN must be defined.")
        String isbn,
        String title,
        String author,
        Double price) {
}
