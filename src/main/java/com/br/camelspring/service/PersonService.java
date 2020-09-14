package com.br.camelspring.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.camelspring.model.PersonModel;
import com.br.camelspring.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	private List<PersonModel> list = new ArrayList<>();
	private PersonModel person = new PersonModel();

	@PostConstruct
	public void initDb() {

		list.add(new PersonModel(1, "Vinicius", 23));
		list.add(new PersonModel(2, "Vittor", 22));
		list.add(new PersonModel(3, "Joao", 50));
	}

	@PostConstruct
	public void initPerson() {
		person.setName("Undefined");
		person.setIdade(0);
	}

	// Method with a call to repository

	public boolean createPersonMockito(PersonModel person) {
		PersonModel createdPersonMock = personRepository.createPerson(new PersonModel(2, "Teste", 777));
		boolean isCreated = (createdPersonMock == null) ? false : true;
		return isCreated;
	}

	public PersonModel getPersonUnic() {
		return this.person;
	}

	public PersonModel createPerson(PersonModel person) {
		list.add(person);
		return person;
	}

	public List<PersonModel> getPerson() {
		return list;
	}

	public String returnStringFromRest(String msg) {
		if (msg.isEmpty()) {
			return "success call from restController -- > " + msg;
		} else {
			return "informe umas mensagem a esse metodo";
		}

	}

	public void updatePerson(PersonModel personModel) {
		if (personModel.getIdade() != 0 && !personModel.getName().equalsIgnoreCase("Undefined")) {
			person.setIdade(personModel.getIdade());
			person.setName(personModel.getName());
		}

	}

}
