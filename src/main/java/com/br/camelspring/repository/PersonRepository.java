package com.br.camelspring.repository;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.br.camelspring.model.PersonModel;

@Component
public class PersonRepository {

	PersonModel personModel = new PersonModel();
	
	@PostConstruct
	public void initPersonModel() {
		personModel.setId(1);
		personModel.setName("PersonModel");
		personModel.setIdade(777);
	}

	
	public PersonModel createPerson(PersonModel person) {
		return person;
	}
	
	public PersonModel updatePerson(PersonModel person) {
		personModel = person;
		return personModel;
	}
}
