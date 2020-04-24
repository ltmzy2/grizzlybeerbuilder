package com.beer.grizzly.factory;

import com.beer.grizzly.common.Constant;

public class GenConfigurationFactory {

    public GenConfiguration getConfiguration(String configuration) {
        if (configuration == null) {
            return null;
        }
        if (configuration.equalsIgnoreCase(Constant.CONFIGURATION)){
            return new FreemarkerGenConfiguration();
        }
        return null;
    }
}
