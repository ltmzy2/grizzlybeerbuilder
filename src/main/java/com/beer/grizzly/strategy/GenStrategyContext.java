package com.beer.grizzly.strategy;

import com.beer.grizzly.entity.GenPara;
import freemarker.template.Configuration;

public class GenStrategyContext {

    private FreemarkerGenStrategy freemarkerGenStrategy;

    public GenStrategyContext(FreemarkerGenStrategy freemarkerGenStrategy) {
        this.freemarkerGenStrategy = freemarkerGenStrategy;
    }

    public String generate(Configuration cfg, GenPara genPara) throws Exception {
        return freemarkerGenStrategy.generate(cfg,genPara);
    }
}
