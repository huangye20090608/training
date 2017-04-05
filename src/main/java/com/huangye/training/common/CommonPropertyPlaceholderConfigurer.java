package com.huangye.training.common;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by huangye on 2017/3/29.
 */
public class CommonPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private static Properties props;

    public Properties mergeProperties() throws IOException {
        props = super.mergeProperties();
        return props;
    }
}
