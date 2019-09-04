package com.jy.x.chain.specific;

import com.jy.x.chain.GenerateChain;
import com.jy.x.entity.GenPara;
import com.jy.x.factory.GenConfiguration;
import com.jy.x.strategy.GenStrategyContext;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-12 10:51
 **/
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

            className = new GenStrategyContext(
                    genPara.getFreemarkerGenStrategy())
                    .generate(configuration.produceConfiguration(), genPara);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return className;
    }
}
