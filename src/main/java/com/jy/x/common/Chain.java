package com.jy.x.common;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 10:19
 **/
public enum Chain {

    //鹿叭叭的service
    //只读
    READONLY("ReadOnlyService", 1),
    //只读实现
    READONLYIMPL("ReadOnlyServiceImpl", 2),
    //接口
    INTERFACE("Service", 3),
    //接口实现
    INTERFACEIMPL("ServiceImpl", 4),
    //getset实体类
    ENTITYGETSET("EntityGetSet", 5);

    private String type;
    private int index;

    Chain(String type, int index) {
        this.type = type;
        this.index = index;
    }

    public static int getGenType(int index) {
        for ( Chain value : Chain.values() ) {
            if (value.getIndex() == index) {
                return value.getIndex();
            }
        }
        return 0;
    }

    public String getType() {
        return type;
    }

    public Chain setType(String type) {
        this.type = type;
        return this;
    }

    public int getIndex() {
        return index;
    }

    public Chain setIndex(int index) {
        this.index = index;
        return this;
    }
}
