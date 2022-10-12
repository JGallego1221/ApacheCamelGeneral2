package com.camel.engine;

import com.camel.routes.ObjToActiveMqRoute;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;
import java.util.Date;

public class ObjectToActiveMqEngine {

    public static void main(String[] args) {

        try{

            CamelContext context = new DefaultCamelContext();
            ConnectionFactory cxf = new ActiveMQConnectionFactory();

            context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(cxf));

            context.addRoutes(new ObjToActiveMqRoute());

            context.start();

            ProducerTemplate pt = context.createProducerTemplate();

            pt.sendBody("direct:start", (new Date()).toString());


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
