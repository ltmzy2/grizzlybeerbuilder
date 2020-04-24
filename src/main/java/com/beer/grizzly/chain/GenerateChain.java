package com.beer.grizzly.chain;

import com.beer.grizzly.entity.GenPara;
import com.beer.grizzly.factory.GenConfiguration;

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
