package com.beer.grizzly.strategy.specific;

import com.beer.grizzly.entity.GenPara;
import com.beer.grizzly.utils.StringUtil;
import com.beer.grizzly.strategy.FreemarkerGenStrategy;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GenerateInterfaceStrategy implements FreemarkerGenStrategy {

    @Override
    public String generate(Configuration cfg, GenPara genPara) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String ftlTemp = "/ServiceTemplate.ftl";
        Template temp = cfg.getTemplate(ftlTemp);
        map.put("packageName", genPara.getPackageName());
        map.put("entityName", genPara.getEntityName());
        map.put("className", genPara.getClassName());
        map.put("baseClassName", genPara.getBaseClassName());
        map.put("entityName2", StringUtil.lowFirstName(genPara.getEntityName()));
        File dir = new ClassPathResource("/templates").getFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        OutputStream fos = new FileOutputStream(new File(dir, genPara.getClassName() + ".java"));
        Writer out = new OutputStreamWriter(fos);
        temp.process(map, out);
        fos.flush();
        fos.close();
        return genPara.getClassName();
    }
}
