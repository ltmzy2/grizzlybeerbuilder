package com.beer.grizzly.factory;

import freemarker.template.Configuration;


public interface GenConfiguration {

    Configuration produceConfiguration() throws Exception;
}
