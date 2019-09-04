package com.jy.x.entity;

import com.jy.x.strategy.FreemarkerGenStrategy;

import java.util.List;
import java.util.Map;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 16:59
 **/
public class GenPara {

    private String packageName;
    private String entityName;
    private String className;
    private String baseClassName;
    private List<Map<String,Object>> typeList;
    private FreemarkerGenStrategy freemarkerGenStrategy;

    public GenPara() {
    }

    public GenPara(String packageName, String entityName, String className, String baseClassName) {
        this.packageName = packageName;
        this.entityName = entityName;
        this.className = className;
        this.baseClassName = baseClassName;
    }

    public FreemarkerGenStrategy getFreemarkerGenStrategy() {
        return freemarkerGenStrategy;
    }

    public GenPara setFreemarkerGenStrategy(FreemarkerGenStrategy freemarkerGenStrategy) {
        this.freemarkerGenStrategy = freemarkerGenStrategy;
        return this;
    }

    public List<Map<String, Object>> getTypeList() {
        return typeList;
    }

    public GenPara setTypeList(List<Map<String, Object>> typeList) {
        this.typeList = typeList;
        return this;
    }

    public String getPackageName() {
        return packageName;
    }

    public GenPara setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public GenPara setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public GenPara setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getBaseClassName() {
        return baseClassName;
    }

    public GenPara setBaseClassName(String baseClassName) {
        this.baseClassName = baseClassName;
        return this;
    }
}
