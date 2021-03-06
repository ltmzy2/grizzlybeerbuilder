package com.beer.grizzly.factory;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

public class FreemarkerGenConfiguration implements GenConfiguration {

    @Override
    public Configuration produceConfiguration() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        File file = new ClassPathResource("/templates").getFile();
        cfg.setDirectoryForTemplateLoading(file);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }
}
