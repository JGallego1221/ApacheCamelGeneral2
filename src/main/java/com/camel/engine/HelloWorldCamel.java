package com.camel.engine;

import com.camel.routes.HelloWorldRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorldCamel {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new HelloWorldRoute());

            context.start();

    }
}
