package com.huangye.training.demo.Log4jTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by huangye on 2017/4/11.
 */
public class Log4jTest {

    private static final org.slf4j.Logger LOGGER1 = LoggerFactory.getLogger(Log4jTest.class);
    private static final Logger LOGGER2 = Logger.getLogger(Log4jTest.class);
    private static Log LOGGER3 = LogFactory.getLog(Log4jTest.class);


    public static void main(String args[]){
        LOGGER1.debug("debug->LoggerFactory.getLogger");
        LOGGER1.info("info->Logger.getLogger");
        LOGGER1.warn("warn->LogFactory.getLog");
        LOGGER1.error("error->LoggerFactory.getLogger");
    }
}
