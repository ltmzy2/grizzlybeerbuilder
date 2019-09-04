package com.jy.x.chain;

import com.jy.x.entity.GenPara;
import com.jy.x.factory.GenConfiguration;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 10:50
 **/
public abstract class GenerateChain {

    protected int level;

    protected GenerateChain nextGenerateChain;

    public GenerateChain setNextGenerateChain(GenerateChain nextGenerateChain) {
        this.nextGenerateChain = nextGenerateChain;
        return this;
    }

    public String generateChain(int level, GenPara genPara, GenConfiguration configuration) {
        if (this.level == level) {
            return assembleGenerateChain(genPara, configuration);
        }
        if (nextGenerateChain != null) {
            return nextGenerateChain.generateChain(level, genPara, configuration);
        }
        return null;
    }

    abstract protected String assembleGenerateChain(GenPara genPara, GenConfiguration configuration);
}
