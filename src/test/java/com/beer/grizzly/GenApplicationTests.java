package com.beer.grizzly;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.stat.TableStat;
import com.beer.grizzly.utils.StringUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class GenApplicationTests {

    @Ignore
    @Test
    public void contextds() {
        try {
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    @Ignore
    @Test
    public void testParseSql() {
        String sql = "CREATE TABLE `b_brand_sss` (\n" +
                "  `id` int(15) unsigned NOT NULL AUTO_INCREMENT COMMENT '车辆品牌id',\n" +
                "  `name` varchar(100) NOT NULL COMMENT '品牌名称',\n" +
                "  `first_letter` varchar(2) NOT NULL COMMENT '品牌开头字母',\n" +
                "  `is_delete` tinyint(4) DEFAULT '0',\n" +
                "  `priority` varchar(4) DEFAULT '100' COMMENT '权重值',\n" +
                "  `created_at` datetime NOT NULL,\n" +
                "  `created_by` varchar(200) DEFAULT NULL COMMENT '用户id',\n" +
                "  `changed_at` datetime DEFAULT NULL,\n" +
                "  `changed_by` varchar(200) DEFAULT NULL,\n" +
                "  `brand_logo` varchar(255) DEFAULT NULL COMMENT '品牌图标',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=utf8 COMMENT='车库品牌表';";

        // 新建 MySQL Parser
        SQLStatementParser parser = new MySqlStatementParser(sql);

        // 使用Parser解析生成AST，这里SQLStatement就是AST
        SQLStatement statement = parser.parseStatement();

        // 使用visitor来访问AST
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        statement.accept(visitor);

        Map<String, Object> map = new LinkedHashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        for ( TableStat.Column column : visitor.getColumns() ) {
            String[] array = column.getName().split("[`_]");
            String[] tableArray = column.getTable().split("[`_]");
            //表名
            map.put("tableName", StringUtil.remove_(tableArray));
            //列名
            map.put("columnName", StringUtil.hightNo1Name(array));
            //字段类型
            map.put("columnDateType", column.getDataType());
            //字段备注
            list.add(map);
        }
        System.out.println(list.toString());
    }

    @Ignore
    @Test
    public void testChar(){
        String b  = "b";
        char[] chars = b.toCharArray();
        chars[0] -= 32;
        System.out.println(String.valueOf(chars));
    }


    @Test
    public void testAop(){
        System.out.println("111");

    }

}
