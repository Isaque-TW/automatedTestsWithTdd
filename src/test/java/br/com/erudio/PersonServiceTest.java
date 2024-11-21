package br.com.erudio;

import br.com.isaque.IPersonService;
import br.com.isaque.PersonService;
import br.com.isaque.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonServiceTest {

    @DisplayName("When Create a Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

        // GIVEN / ARRANGE
        IPersonService service = new PersonService();

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
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

}
