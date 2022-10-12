package com.camel.engine;

import com.camel.routes.ConsumeActiveMqRoute;
import com.camel.routes.ObjToActiveMqRoute;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class ActiveMqConsumerEngine {

    public static void main(String[] args) {

        CamelContext context = new DefaultCamelContext();

        ConnectionFactory cxf = new ActiveMQConnectionFactory();

        //context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(cxf));

        context.addComponent("jms", JmsComponent.jmsComponentTransacted(cxf));

        try{

            context.addRoutes(new ConsumeActiveMqRoute());
        } catch(Exception e){
            e.printStackTrace();
            System.exit(10);
        }

        while (true) {

            try{

                context.start();
                ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
                String message = (String) consumerTemplate.receiveBody("seda:end");
                System.out.println("Received Message :::: " + message);
            } catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
