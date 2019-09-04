package com.jy.x.factory;

import static com.jy.x.common.Constant.CONFIGURATION;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 18:19
 **/
public class GenConfigurationFactory {

    public GenConfiguration getConfiguration(String configuration) {
        if (configuration == null) {
            return null;
        }
        if (configuration.equalsIgnoreCase(CONFIGURATION)){
            return new FreemarkerGenConfiguration();
        }
        return null;
    }
}
