package com.jy.x.factory;

import freemarker.template.Configuration;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 18:02
 **/
public interface GenConfiguration {

    Configuration produceConfiguration() throws Exception;
}
