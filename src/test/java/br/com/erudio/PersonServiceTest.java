package br.com.erudio;

import br.com.isaque.IPersonService;
import br.com.isaque.PersonService;
import br.com.isaque.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    IPersonService service;
    Person person;

    @BeforeEach
    void setup () {
        service = new PersonService();
         person = new Person(
                "Keith",
                "Moon",
                "kmoon@erudio.com",
                "Wembley - UK",
                "Male"
        );
    }

    @DisplayName("When Create a Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

        // GIVEN / ARRANGE
        Person person = new Person(
                "Keith",
                "Moon",
                "kmoon@erudio.com",
                "Wembley - UK",
                "Male"
        );

        // WHEN / ACT
       Person actual = service.createPerson(person);

        //THEN / ASSERT
        assertNotNull(person.getId(), () -> "Person ID is Missing");
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When Create a Person with Success Should Contains valid Fields in Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsValidFieldsInReturnedPersonObject() {

        // GIVEN / ARRANGE

        // WHEN / ACT
        Person actual = service.createPerson(person);

        //THEN / ASSERT
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The Person FirstName is Incorrect!");

        assertEquals(person.getLastName(), actual.getLastName(), () -> "The Person LastName is Incorrect!");

        assertEquals(person.getAddress(), actual.getAddress(), () -> "The Person Address is Incorrect!");

        assertEquals(person.getGender(), actual.getGender(), () -> "The Person Gender is Incorrect!");

        assertEquals(person.getEmail(), actual.getEmail(), () -> "The Person email is Incorrect!");

    }

    @DisplayName("When Create a Person with null e-mail Should throw Exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
        // Given / Arrange
        person.setEmail(null);

        var expectedMessage = "The Person E-mail is null or empty!";

        // When / Act & Then / Assert
       IllegalArgumentException exception =  assertThrows(
                IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Empty e-mail should have cause an IllegalArgumentException!"
        );

       // Then / Assert
        assertEquals(
                expectedMessage,
                exception.getMessage(),
                () -> "Exception error message is incorrect!");
    }
}
