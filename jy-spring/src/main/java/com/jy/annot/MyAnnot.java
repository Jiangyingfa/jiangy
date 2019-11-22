package com.jy.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//标记的注释由JVM保留，因此运行时环境可以使用它
@Target({ElementType.METHOD,ElementType.TYPE})//注释标记另一个注释，以限制可以应用注释的Java元素类型: 作用在方法上的注解
public @interface MyAnnot {
    String value() default "546466";

}
