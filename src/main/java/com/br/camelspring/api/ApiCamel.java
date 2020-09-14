package com.br.camelspring.api;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.camelspring.processor.PersonProcessor;
import com.br.camelspring.service.PersonService;

@Component
public class ApiCamel extends RouteBuilder {

	@Autowired
	PersonService personService;

	@BeanInject
	PersonProcessor personProcessor;

	@Override
	public void configure() throws Exception {
		// restConfiguration().component("servlet").port(8080).host("localhost").bindingMode(RestBindingMode.json);

		rest().post("/hello").to("direct:hello");

		from("direct:hello").unmarshal().json().log("Hello World from a different place is ${body}").transform()
				.simple("${body}").to("mock:output");

		rest().get("/helloGet").to("direct:helloGet");

		from("direct:hello").log("Hello World from a different place is ${body}").transform().simple("${body}");

//		rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("restApiCamel"))
//				.endRest();
//
//		rest().post("/createPerson").consumes(MediaType.APPLICATION_JSON_VALUE).type(PersonModel.class)
//				.outType(PersonModel.class).route().process(personProcessor).endRest();
//
//		rest().put("/updatePerson").consumes(MediaType.APPLICATION_PROBLEM_JSON_VALUE).type(PersonModel.class)
//				.outType(PersonModel.class).route().process(new Processor() {
//
//					@Override
//					public void process(Exchange exchange) throws Exception {
//						personService.updatePerson(exchange.getIn().getBody(PersonModel.class));
//					}
//				}).endRest();
//
//		rest().get("/getPersons").produces(MediaType.APPLICATION_JSON_VALUE).route()
//				.setBody(constant(personService.getPerson())).endRest();

	}
}
