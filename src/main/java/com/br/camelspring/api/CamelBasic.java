package com.br.camelspring.api;

import org.apache.camel.builder.RouteBuilder;

/**
 * A basic example running as public static void main.
 */
public final class CamelBasic extends RouteBuilder {

	@Override
	public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:output");
    }
	
	
	


}