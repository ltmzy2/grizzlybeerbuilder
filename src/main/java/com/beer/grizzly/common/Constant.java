package com.beer.grizzly.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 13:38
 **/
@Component
public class Constant {

    public static final String PACKAGE = "com.shunlu.cloud.service";

    public static final String PACKAGE_IMPL = "com.shunlu.cloud.service.impl";

    public static final String BASE = "Base";

    public static final String READONLY_SERVICE = "ReadOnlyService";

    public static final String READONLY_SERVICE_IMPL = "ReadOnlyServiceImpl";

    public static final String SERVICE = "Service";

    public static final String SERVICE_IMPL = "ServiceImpl";

    public static final String CONFIGURATION = "x";

    public static final String ZIP_SYFFIX = ".zip";

    public static String templatesFilePath;

    public static String zipFilePath;

    @Value("${zipfile.path}")
    public void setZipFilePath(String zipFilePath) {
        Constant.zipFilePath = zipFilePath;
    }

    @Value("${templatesfile.path}")
    public void setTemplates(String templatesFilePath) {
        Constant.templatesFilePath = templatesFilePath;
    }
}
