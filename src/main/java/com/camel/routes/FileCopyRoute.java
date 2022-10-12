package com.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import java.util.Map;

public class       FileCopyRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("file:input_box?noop=true&delete=true")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {


                        System.out.println("Processing file .... " + exchange.getMessage().getHeaders().get("CamelFileName").toString());
                    }
                })
                .to("file:output_box");
    }
}
