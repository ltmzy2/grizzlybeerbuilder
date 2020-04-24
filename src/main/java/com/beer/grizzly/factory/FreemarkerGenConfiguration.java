package com.beer.grizzly.factory;

import com.beer.grizzly.common.Constant;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FreemarkerGenConfiguration implements GenConfiguration {

    @Override
    public Configuration produceConfiguration() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File(Constant.templatesFilePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }
}
