package com.beer.grizzly.chain.specific;

import com.beer.grizzly.common.Constant;
import com.beer.grizzly.entity.GenPara;
import com.beer.grizzly.utils.StringUtil;
import com.beer.grizzly.chain.GenerateChain;
import com.beer.grizzly.factory.GenConfiguration;
import com.beer.grizzly.strategy.GenStrategyContext;

public class GenerateInterfaceHandler extends GenerateChain {

    public GenerateInterfaceHandler(int level) {
        this.level = level;
    }

    @Override
    public String assembleGenerateChain(GenPara genPara, GenConfiguration configuration) {
        String className = "";
        try {
            genPara.setPackageName(Constant.PACKAGE);
            genPara.setBaseClassName(Constant.BASE + Constant.SERVICE);
            genPara.setClassName(StringUtil.removeFirstName(genPara.getEntityName()) + Constant.SERVICE);

            className = new GenStrategyContext(
                    genPara.getFreemarkerGenStrategy())
                    .generate(configuration.produceConfiguration(), genPara);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return className;
    }
}
