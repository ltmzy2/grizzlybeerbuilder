package com.beer.grizzly.chain.specific;

import com.beer.grizzly.common.Constant;
import com.beer.grizzly.entity.GenPara;
import com.beer.grizzly.utils.StringUtil;
import com.beer.grizzly.chain.GenerateChain;
import com.beer.grizzly.factory.GenConfiguration;
import com.beer.grizzly.strategy.GenStrategyContext;
import freemarker.template.Configuration;

public class GenerateReadOnlyImplHandler extends GenerateChain {

    public GenerateReadOnlyImplHandler(int level) {
        this.level = level;
    }

    @Override
    public String assembleGenerateChain(GenPara genPara, GenConfiguration configuration) {
        String className = "";
        try {
            genPara.setPackageName(Constant.PACKAGE_IMPL);
            genPara.setClassName(StringUtil.removeFirstName(genPara.getEntityName()) + Constant.READONLY_SERVICE_IMPL);
            genPara.setBaseClassName(Constant.BASE + Constant.READONLY_SERVICE_IMPL);

            Configuration cfg = configuration.produceConfiguration();
            className = new GenStrategyContext(genPara.getFreemarkerGenStrategy()).generate(cfg, genPara);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return className;
    }
}
