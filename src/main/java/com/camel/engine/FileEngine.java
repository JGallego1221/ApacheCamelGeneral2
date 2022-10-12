package com.camel.engine;

import com.camel.routes.FileCopyRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class FileEngine {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new FileCopyRoute());

        while(true) {
            context.start();
            Thread.sleep(2000);
        }

    }
}
