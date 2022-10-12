package com.camel.engine;

import com.camel.routes.ProducerRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class ConsumerProducerEngine {

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new ProducerRoute());

        context.start();

        ProducerTemplate pt = context.createProducerTemplate();
        pt.sendBody("direct:start", "Sending Message!1");
        pt.sendBody("direct:start", "Sending Message!2");
        pt.sendBody("direct:start", "Sending Message!3");

        ConsumerTemplate ct = context.createConsumerTemplate();
        String message = (String) ct.receiveBody("seda:end");

        System.out.println(message);
        message = (String) ct.receiveBody("seda:end");

        System.out.println(message);
        message = (String) ct.receiveBody("seda:end");

        System.out.println(message);
    }
}
