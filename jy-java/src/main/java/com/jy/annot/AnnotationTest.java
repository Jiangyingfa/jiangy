package com.jy.annot;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 注解：1、常用的JDK注解：① @Override 限定重写父类方法，该注解只能用于方法；
 *                     ② @Deprecated 表示用于某个程序元素（类，方法）已过时；
 *                     ③ @SuppressWarnings 用于抑制编译器的警告；
 *     2、如何自定义注解
 *     自定义注解必须使用到2个元注解：@Retention 、 @Target
 *
 *     3、如何对注解进行注解：元注解，即可以对注解进行解释说明  （了解）
 *     ①Retention 标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问
 *     ②Target 标记这个注解是哪种Java成员
 *     ③Documented 标记这些注解是否包含在用户文档中
 *     ④Inherited 表明该注解是否具有集成性
 *
 */
@MyAnnot("in Class")
public class AnnotationTest {

    @MyAnnot("in method")
    public void test(){

    }

    public static void main(String[] args) {
        Class c = AnnotationTest.class;
        Class annotation = MyAnnot.class;

        //判断C这个类是否有在annotation类定义的注解
        if(c.isAnnotationPresent(annotation)){
            MyAnnot currentAnnot = (MyAnnot)c.getAnnotation(annotation);
            System.out.println(currentAnnot.value());
        }

        //判断C这个类中的方法，是否有annotation的注解
        Method[] methods = c.getMethods();
        for (int i=0; i<methods.length; i++){
            if (methods[i].isAnnotationPresent(annotation)){
                MyAnnot currentAnnot = (MyAnnot)methods[i].getAnnotation(annotation);
                System.out.println(currentAnnot.value());
            }
        }
    }

}
