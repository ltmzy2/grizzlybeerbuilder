package com.jy.x.strategy;

import com.jy.x.entity.GenPara;
import freemarker.template.Configuration;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 17:08
 **/
public class GenStrategyContext {

    private FreemarkerGenStrategy freemarkerGenStrategy;

    public GenStrategyContext(FreemarkerGenStrategy freemarkerGenStrategy) {
        this.freemarkerGenStrategy = freemarkerGenStrategy;
    }

    public String generate(Configuration cfg, GenPara genPara) throws Exception {
        return freemarkerGenStrategy.generate(cfg,genPara);
    }
}
