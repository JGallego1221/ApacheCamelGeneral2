package com.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class FileToActiveMqRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input_box?noop=true")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Sending File ... " + exchange.getMessage().getHeaders().get("CamelFileName"));
                    }
                })
                .to("activemq:queue:my_queue");
    }
}
