package com.camel.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class ConsumeActiveMqRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:queue:my_queue")
                .doTry()
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Thread.sleep(20000);
                        System.out.println(exchange.getMessage().getBody().toString());

                        throw new Exception("TEST Exception");
                    }
                }) .to("seda:end")
                .doCatch(Exception.class)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("exception thrown");
                       // System.exit(10);
                    }
                }).to("activemq:queue:error_queue")
               ;
    }

}
