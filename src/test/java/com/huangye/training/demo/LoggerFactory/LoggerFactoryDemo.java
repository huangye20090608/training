package com.huangye.training.demo.LoggerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by huangye on 2017/4/11.
 */
public class LoggerFactoryDemo {
    private static final org.slf4j.Logger LOGGER1 = LoggerFactory.getLogger(LoggerFactoryDemo.class);
    private static final Logger LOGGER2 = Logger.getLogger(LoggerFactoryDemo.class);
    private static Log LOGGER3 = LogFactory.getLog(LoggerFactoryDemo.class);


    public static void main(String args[]){
        LOGGER1.debug("debug->LoggerFactory.getLogger");
        LOGGER1.info("info->LogFactory.getLog");
        LOGGER1.warn("warn->LogFactory.getLog");
        LOGGER1.error("error->Logger.getLogger");
    }
}
