package com.camel.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestEngine {

//    private static final Logger logger = LogManager.getLogger(TestEngine.class);

    private static final Log logger = LogFactory.getLog(TestEngine.class);

    public static void main(String[] args) {

        System.out.println("This is " + (new TestEngine()).getClass().getSimpleName() + " Class");
        Integer x = 4;

        logger.info("1. x value is " +x);

        if (x.equals(4)) {
            System.out.println("wtf");
            x = 6;
        }
        System.out.println(x);
        logger.debug("2. x value is " +x);


    }
}
