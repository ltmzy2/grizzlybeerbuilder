package com.beer.grizzly.strategy;

import com.beer.grizzly.entity.GenPara;
import freemarker.template.Configuration;

@FunctionalInterface
public interface FreemarkerGenStrategy {

    String generate(Configuration cfg, GenPara genPara) throws Exception;
}
