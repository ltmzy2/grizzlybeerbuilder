package com.jy.x.chain.specific;

import com.jy.x.chain.GenerateChain;
import com.jy.x.entity.GenPara;
import com.jy.x.factory.GenConfiguration;
import com.jy.x.strategy.GenStrategyContext;
import com.jy.x.utils.StringUtil;
import freemarker.template.Configuration;

import static com.jy.x.common.Constant.*;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 11:00
 **/
public class GenerateReadOnlyImplHandler extends GenerateChain {

    public GenerateReadOnlyImplHandler(int level) {
        this.level = level;
    }

    @Override
    public String assembleGenerateChain(GenPara genPara,GenConfiguration configuration) {
        String className = "";
        try {
            genPara.setPackageName(PACKAGE_IMPL);
            genPara.setClassName(StringUtil.removeFirstName(genPara.getEntityName()) + READONLY_SERVICE_IMPL);
            genPara.setBaseClassName(BASE + READONLY_SERVICE_IMPL);

            Configuration cfg = configuration.produceConfiguration();
            className = new GenStrategyContext(genPara.getFreemarkerGenStrategy()).generate(cfg, genPara);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return className;
    }
}
