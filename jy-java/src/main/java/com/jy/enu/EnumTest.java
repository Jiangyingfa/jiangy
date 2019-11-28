package com.jy.enu;

import org.junit.jupiter.api.Test;

/**
 * 1、如何自定义枚举类：（枚举类：对象有限个，且确定）
 *    ①私有化类的构造器，保证不能在类的外部创建对象。因为枚举类是有限的，如果一开始不限制大小，后面就可以无限制添加，这就违背了“枚举”的定义。
 *    ②在类的内部创建枚举类的对象。声明为：public static final
 *    ③如果枚举类有属性，则属性需要声明为：private final。此属性在构造器中赋值
 *
 *
 * 2、jdk1.5后对枚举类关键字enum的使用: values()方法、valueOf(String name)方法
 * 3、枚举类如何实现接口：
 *    ①让类实现此接口，类的对象共享同一套抽象方法的实现；（效果一致）
 *    ②让类的每一个对象都去实现接口的抽象方法，通过类的对象调用被重写的抽象方法，来实现不同的效果；（效果不同）
 *
 */
public class EnumTest {
    @Test
    public void test(){
        Season[] season = Season.values();
        for (int i=0; i<season.length; i++){
            System.out.printf("name=" + Season.valueOf(season[i].name()) + ",description=");
            season[i].show();
            System.out.println();
        }
    }


}
