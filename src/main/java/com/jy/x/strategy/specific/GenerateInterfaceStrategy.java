package com.jy.x.strategy.specific;

import com.jy.x.entity.GenPara;
import com.jy.x.strategy.FreemarkerGenStrategy;
import com.jy.x.utils.StringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 18:10
 **/
public class GenerateInterfaceStrategy implements FreemarkerGenStrategy {

    @Override
    public String generate(Configuration cfg,GenPara genPara) throws Exception {
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
