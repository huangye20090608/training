package com.huangye.training.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by huangye on 2017/3/30.
 */
public class TenantInitController implements InitializingBean {
    private Logger log = LoggerFactory.getLogger(TenantInitController.class);


    public void afterPropertiesSet() throws Exception {

    }
}
