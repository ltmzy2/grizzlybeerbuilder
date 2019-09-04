package com.jy.x.utils;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 11:09
 **/
public class StringUtil {

    /**
     * 第二个字符位置开始ascii+32转换为小写并删除表名前缀
     *
     * @param s
     * @return java.lang.String
     * @author: Jy  2019/8/2 16:51
     */
    public static String lowFirstName(String s) {
        char[] cs = s.toCharArray();
        cs[1] += 32;
        return String.valueOf(cs).substring(1);
    }

    /**
     * 删除表名前缀
     *
     * @param s
     * @return java.lang.String
     * @author: Jy  2019/8/2 16:51
     */
    public static String removeFirstName(String s) {
        return s.substring(1);
    }


    /**
     * 首字母变大写
     *
     * @param s
     * @return java.lang.String
     * @author: Jy  2019/8/9 14:06
     */
    public static String highFirstName(String s) {
        char[] cs = s.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * 切割后的字符除了第一个元素剩下的都转换为大写
     *
     * @param array
     * @return java.lang.String
     * @author: Jy  2019/8/9 14:29
     */
    public static String hightNo1Name(String[] array) {
        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < array.length; i++ ) {
            if (i < 2) {
                sb.append(array[i]);
            } else {
                //下划线后面字段首字母转换为大写
                sb.append(StringUtil.highFirstName(array[i]));
            }
        }
        return sb.toString();
    }

    /**
     * 去除下划线 首字母变大写
     *
     * @param array
     * @return java.lang.String
     * @author: Jy  2019/8/9 14:32
     */
    public static String remove_(String[] array) {
        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < array.length; i++ ) {
            if (i < 1) {
                //toCharArray会越界,直接转大写
                sb.append(array[i].toUpperCase());
            }else {
                sb.append(StringUtil.highFirstName(array[i]));
            }
        }
        return sb.toString();
    }

    /**
     * 去除下划线 首字母变大写
     *
     * @param s
     * @return java.lang.String
     * @author: Jy  2019/8/9 14:34
     */
    public static String remove_(String s) {
        String[] array = s.split("[`_]]");
        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < array.length; i++ ) {
            String s1 = highFirstName(array[i]);
            sb.append(s1);
        }
        return sb.toString();
    }
}
