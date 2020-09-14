package com.br.camelspring;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.br.camelspring.api.CamelBasic;

public class TestApiCamelIntegrado extends CamelTestSupport {

	@Override
	public RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelBasic();
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void sampleMockTestDirectSampleInput() throws InterruptedException {
		String expected = "Hello";

		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);
		String input = "Hello";
		template.sendBody("direct:sampleInput", input);
		assertMockEndpointsSatisfied();
	}

}
