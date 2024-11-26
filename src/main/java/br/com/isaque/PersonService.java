package br.com.isaque;

import br.com.isaque.model.Person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService{
    @Override
    public Person createPerson(Person person) {

        if (person.getEmail() == null || person.getEmail().isBlank())
            throw new IllegalArgumentException("The Person E-mail is null or empty!");

        var id = new AtomicLong().incrementAndGet();
        person.setId(id);  // SIMULANDO BASE DE DADOS
        return person;
    }
}
