package com.beer.grizzly;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Constructor;

@Ignore
public class ConstructorTest {

    @Test
    public void test() {
        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.beer.grizzly.Dept");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("修饰符"+constructor.getModifiers());
            System.out.println("构造方法名："+constructor.getName());
        }

    }
    public static void main(String[] args) {

        int num = 30;
        int swap = swap(num);
        System.out.println(num);
        System.out.println(swap);
//        Unsafe();
//        AtomicInteger();
    }

    public static int  swap(int para){
        return para = 100;
    }
}
