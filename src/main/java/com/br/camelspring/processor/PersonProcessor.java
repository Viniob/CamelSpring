package com.br.camelspring.processor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.camelspring.model.PersonModel;
import com.br.camelspring.service.PersonService;



@Component
public class PersonProcessor implements Processor{

	@Autowired
	PersonService personService;

	@Override
	public void process(Exchange exchange) throws Exception {
		PersonModel personBody = exchange.getIn().getBody(PersonModel.class);
		if(personBody.getIdade() < 30) {
			personBody.setName(personBody.getName()+"idade menor que 30");
		}
		personService.createPerson(personBody);

	}

}
