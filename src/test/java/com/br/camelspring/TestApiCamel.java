package com.br.camelspring;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.camelspring.api.ApiCamel;
import com.br.camelspring.api.CamelBasic;
import com.br.camelspring.model.PersonModel;
import com.br.camelspring.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestApiCamel{

	@Autowired
	PersonService personService;

	


//	@Autowired
//	private TestRestTemplate restTemplate;

	/*
	 * @Test public void BgetSizeListApiCamel() { Person[] personList =
	 * this.restTemplate.getForObject("/getPersons", Person[].class);
	 * assertEquals(3, personList.length); }
	 * 
	 * @Test public void CcreatePersonApiTeste() { Person personToSave = new
	 * Person(1, "Tester Person", 33); ResponseEntity<Person> responseEntity =
	 * this.restTemplate.postForEntity("/createPerson", personToSave, Person.class);
	 * Person personCreated = responseEntity.getBody(); assertEquals(personToSave,
	 * personCreated); }
	 * 
	 * 
	 * @Test public void updatePerson() { Person personToUpdate = new Person(1,
	 * "Updated Person", 99); this.restTemplate.put("/updatePerson", personToUpdate,
	 * Person.class); Person personUnic = personSerivce.getPersonUnic();
	 * assertEquals(personToUpdate, personUnic); }
	 */



	/*
	 * @Test public void testeApiCamel() throws Exception { ApiCamel apiCamel = new
	 * ApiCamel(); apiCamel.configure(); }
	 */
	

	
	
	@Test
	public void TestServiceMsg() {
		String msg = "informe umas mensagem a esse metodo";
		String returnStringFromRest = personService.returnStringFromRest("mensagem");
		assertEquals(returnStringFromRest, msg);
	}

}
