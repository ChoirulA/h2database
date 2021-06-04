package com.choirula.h2database.repository;

import com.choirula.h2database.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void findByName_shouldSuccess() {
        Person person = new Person(1L,"Cho A", "Jogja");
        personRepository.save(person);
        Person result = personRepository.findByName("Cho A");
        Assert.assertNotNull(result);
    }

    @Test
    void findByName_shouldNotSuccess(){
        Person person2 = new Person(2L, "Choi A", "Jogja");
        personRepository.save(person2);
        Person result2 = personRepository.findByName("Cho A");
        Assert.assertNull(result2);
    }

}