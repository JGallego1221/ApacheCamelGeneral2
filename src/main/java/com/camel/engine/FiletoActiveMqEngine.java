package com.camel.engine;

/*import com.camel.routes.SendToActiveMqRoute;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;

import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;*/

import com.camel.routes.FileToActiveMqRoute;
//import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class FiletoActiveMqEngine {

    public static void main(String[] args)  {

        try{

            CamelContext context = new DefaultCamelContext();
            ConnectionFactory cf = new ActiveMQConnectionFactory();

            context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(cf));

            context.addRoutes(new FileToActiveMqRoute());
     /*   context.addRoutes(new RouteBuilder() {
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
        });*/
            try {
                while (true)
                    context.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
