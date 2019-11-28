package com.jy.generics;

/**
 * 自定义泛型类
 */
public class BaseDao<T> {

    public void getById(Long id){
        //TODO:根据ID执行查询，并返回对象
        //上面的void类型实际应该为T
    }

    public T add (T t){
        //TODO:执行数据库保存
        System.out.println();
        return t;
    }

    public T update (T t){
        //TODO:执行数据库修改
        return t;
    }

    public void delete (T t){
        //TODO:执行数据库删除
    }

    /**
     * 调用方法时，已经指明E的具体类型，所以这里可以使用static修饰符
     */
    public static <E> E get(E e){
        return e;
    }
}
