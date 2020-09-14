package com.br.camelspring;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.br.camelspring.api.ApiCamel;
import com.br.camelspring.model.PersonModel;


public class SampleDirectRouteTest extends CamelTestSupport {

	

    public RoutesBuilder createRouteBuilder() throws Exception {
        return new ApiCamel();
    }
	
	
	@Test
	public void sampleMockTestRestTemplate() throws InterruptedException {
		String expected = "Hello World";
		PersonModel personModel = new PersonModel(4, "undefined", 999);
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(personModel);
		String input = "Hello World";
		
		template.sendBody("direct:hello", personModel);
		assertMockEndpointsSatisfied();

	}
}
