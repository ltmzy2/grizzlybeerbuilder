package com.beer.grizzly.chain.specific;

import com.beer.grizzly.entity.GenPara;
import com.beer.grizzly.chain.GenerateChain;
import com.beer.grizzly.factory.GenConfiguration;
import com.beer.grizzly.strategy.GenStrategyContext;

public class GenerateEntityGetSetHandler extends GenerateChain {

    public GenerateEntityGetSetHandler(int level) {
        this.level = level;
    }

    @Override
    protected String assembleGenerateChain(GenPara genPara, GenConfiguration configuration) {
        String className = "";
        try {
            genPara.setPackageName(genPara.getPackageName());
            genPara.setClassName(genPara.getClassName());

            className = new GenStrategyContext(genPara.getFreemarkerGenStrategy()).generate(configuration.produceConfiguration(), genPara);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return className;
    }
}
