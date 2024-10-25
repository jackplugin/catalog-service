package org.jack.cloudnative.catalogservice.domain;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookValidationTests {
    private static Validator validator;
    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void givenAllFieldsCorrect_whenValidate_shouldNoValidationErrors() {
        //Arrange
        var book = new Book("001", "Learning Cloud Native Development", "Jack Li", 12.04);

        //Act
        var errors = validator.validate(book);

        //Assert
        assertThat(errors).hasSize(0);
    }

    @Test
    void givenISBNIsBlank_whenValidate_shouldReturnValidationErrors() {
        //Arrange
        var book = new Book("", "Learning Cloud Native Development", "Jack Li", 12.04);
        var expected = "The book ISBN must be defined.";

        //Act
        var errors = validator.validate(book);

        //Assert
        assertThat(errors).hasSize(1);
        assertThat(errors.iterator().next().getMessage()).isEqualTo(expected);
    }

}
