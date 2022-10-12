package com.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class ObjToActiveMqRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:start")
             /*   .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Sending Message .... " + exchange.getMessage().getBody().toString());
                    }
                })*/
                .to("activemq:queue:my_queue");
    }
}
