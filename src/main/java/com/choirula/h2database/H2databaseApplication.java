package com.choirula.h2database;

import com.choirula.h2database.model.Person;
import com.choirula.h2database.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class H2databaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(H2databaseApplication.class, args);

		//init person repository
		PersonRepository personRepository = context.getBean(PersonRepository.class);

		//init data
		Person person1 = new Person("Cho A", "Yogya");
		personRepository.save(person1);

		//should success
		Optional<Person> resultById = personRepository.findById(1L);
		if(resultById.isPresent()){
			System.out.println(resultById.toString());
		}else{
			System.out.println("Data tidak ditemukan");
		}

		//should fail
		Optional<Person> resultById1 = personRepository.findById(2L);
		if(resultById1.isPresent()){
			System.out.println(resultById1.toString());
		}else{
			System.out.println("Data tidak ditemukan");
		}

		//should success
		Person person2 = personRepository.findByName("Cho A");
		if(person2 != null){
			System.out.println(person2.toString());
		}else{
			System.out.println("Data tidak ditemukan");
		}

		//should fail
		Person result = personRepository.findByName("Cho");
		if(result != null){
			System.out.println(result.toString());
		}else{
			System.out.println("Data tidak ditemukan");
		}
	}

}
