package com.jy.x.strategy.specific;

import com.jy.x.entity.GenPara;
import com.jy.x.strategy.FreemarkerGenStrategy;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-12 10:57
 **/
public class GenerateEntityGetSetStrategy implements FreemarkerGenStrategy {

    @Override
    public String generate(Configuration cfg, GenPara genPara) throws Exception {

        Map<String, Object> map = new HashMap<>();

        String ftlTemp = "/EntityGetSet.ftl";
        Template temp = cfg.getTemplate(ftlTemp);

        map.put("packageName", genPara.getPackageName());
        map.put("className", genPara.getClassName());
        map.put("typeList",genPara.getTypeList());

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
