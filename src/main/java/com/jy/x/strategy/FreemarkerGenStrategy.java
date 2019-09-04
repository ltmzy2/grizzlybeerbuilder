package com.jy.x.strategy;

import com.jy.x.entity.GenPara;
import freemarker.template.Configuration;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 16:56
 **/
@FunctionalInterface
public interface FreemarkerGenStrategy {

    String generate(Configuration cfg, GenPara genPara) throws Exception;
}
