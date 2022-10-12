package com.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class ProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
         from("direct:start")
                 .process(new Processor() {
                     @Override
                     public void process(Exchange exchange) throws Exception {
                         System.out.println("message received.... ");
                         /*System.out.println(exchange.getMessage().getBody().toString());
                         String initMsg = exchange.getMessage().getBody().toString();

                         exchange.getMessage().setBody("This is processed a Message - " + initMsg);*/
//                         exchange.setMessage(msg);

                         String msg = (String)exchange.getIn().getBody();
                         msg = msg + " - By sender";

                         exchange.getMessage().setBody(msg);
                         System.out.println(msg);
                         System.out.println("message end.... ");
                     }
                 })
                 .to("seda:end");
    }
}
