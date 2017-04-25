package com.huangye.training.demo.Log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by huangye on 2017/4/11.
 */
public class Log4jDemo {
    private static final org.slf4j.Logger LOGGER1 = LoggerFactory.getLogger(Log4jDemo.class);
    private static final Logger LOGGER2 = Logger.getLogger(Log4jDemo.class);
    private static Log LOGGER3 = LogFactory.getLog(Log4jDemo.class);

    public static void main(String args[]){
//        LOGGER1.debug("debug->LoggerFactory.getLogger");
//        LOGGER1.info("info->Logger.getLogger");
//        LOGGER1.warn("warn->LogFactory.getLog");
//        LOGGER1.error("error->LoggerFactory.getLogger");
        Byte a = 1;
        if(Byte.valueOf((byte)129) == Byte.valueOf((byte)129)){
            System.out.println("success!!!");
        }else{
            System.out.println("error!!!");
        }


    }
}
