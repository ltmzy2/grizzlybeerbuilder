package com.beer.grizzly.utils;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.stat.TableStat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SqlParseUtil {

    public static List<Map<String, Object>> parseSql(String sql) {

        // 新建 MySQL Parser
        SQLStatementParser parser = new MySqlStatementParser(sql);
        // 使用Parser解析生成AST，这里SQLStatement就是AST
        SQLStatement statement = parser.parseStatement();
        // 使用visitor来访问AST
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        statement.accept(visitor);

        List<Map<String, Object>> list = new ArrayList<>();
        for ( TableStat.Column column : visitor.getColumns() ) {
            Map<String, Object> map = new LinkedHashMap<>();
            String[] array = column.getName().split("[`_]");
            String[] tableArray = column.getTable().split("[`_]");
            //表名
            map.put("tableName", StringUtil.remove_(tableArray));
            //列名
            map.put("name", StringUtil.hightNo1Name(array));
            //字段类型
            map.put("type", conversion(column.getDataType()));
            //字段备注
            list.add(map);
        }
        return list;
    }

    /**
     *  mysql类型转java
     * @param dataType
     * @return java.lang.String
     * @author: Jy  2019/8/12 14:51
     */
    private static String conversion(String dataType) {
        if (dataType == null) {
            return null;
        }
        if ("VARCHAR".equalsIgnoreCase(dataType)) {
            return "String";
        }
        if ("CHAR".equalsIgnoreCase(dataType)) {
            return "String";
        }
        if ("BLOB".equalsIgnoreCase(dataType)) {
            return "byte[]";
        }
        if ("TEXT".equalsIgnoreCase(dataType)) {
            return "String";
        }
        if ("INTEGER".equalsIgnoreCase(dataType)) {
            return "Long";
        }
        if ("TINYINT".equalsIgnoreCase(dataType)) {
            return "Integer";
        }
        if ("SMALLINT".equalsIgnoreCase(dataType)) {
            return "Integer";
        }
        if ("MEDIUMINT".equalsIgnoreCase(dataType)) {
            return "Integer";
        }
        if ("BIT".equalsIgnoreCase(dataType)) {
            return "Boolean";
        }
        if ("BIGINT".equalsIgnoreCase(dataType)) {
            return "BigInteger";
        }
        if ("FLOAT".equalsIgnoreCase(dataType)) {
            return "Float";
        }
        if ("DOUBLE".equalsIgnoreCase(dataType)) {
            return "Double";
        }
        if ("DECIMAL".equalsIgnoreCase(dataType)) {
            return "BigDecimal";
        }
        if ("BOOLEAN".equalsIgnoreCase(dataType)) {
            return "Integer";
        }
        if ("DATE".equalsIgnoreCase(dataType)) {
            return "Date";
        }
        if ("TIME".equalsIgnoreCase(dataType)) {
            return "Time";
        }
        if ("DATETIME".equalsIgnoreCase(dataType)) {
            return "Date";
        }
        if ("TIMESTAMP".equalsIgnoreCase(dataType)) {
            return "Timestamp";
        }
        if ("YEAR".equalsIgnoreCase(dataType)) {
            return "Date";
        }
        return dataType;
    }
}
