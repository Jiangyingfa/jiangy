package com.jy.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型：1、在集合中的使用：集合默认有泛型
 *      2、自定义泛型类、接口、方法：参考msc中的BaseDao的写法
 *      3、泛型与继承的关系
 *      4、通配符
 * 注意点：1、泛型修饰类时，类不能使用static修饰，因为静态初始化在前，而泛型无法指定初始化的类型。
 *       2、可以修饰方法，因为泛型的类型已经通过形参确定，调用方法是通过参数即可确定泛型。
 *       3、泛型与继承没有直接关系。A是B的父类，List<A>与List<B>是平等关系，属于同一层级。
 *       4、A是B的父类，List<?>是List<A>、List<B>的父类：
 *          ①以List<?>为例，能读取里面的数据，因为所有类型都是Object的子类；
 *          ②以List<?>为例，不能向其写入数据，因为没有指明元素具体的类型，null是唯一可以被写入的数据；
 *       5、有条件限制的通配符：
 *          List<A extends ?>表示该泛型只能是A及其父类；List<? extends A>表示该泛型只能是A及其子类。
 *
 * 自定义泛型类的注意点：
 *        1、对象实例化时不指定泛型，默认为Object类型。
 *        2、泛型间不同的引用不能相互赋值
 *        3、加入集合中的元素类型必须与指定的泛型类型一致
 *        4、静态方法中不能使用泛型
 *        5、如果泛型类是一个接口或者抽象类，则不可创建泛型类的对象：是由于接口和抽象类本身的限制造成
 *        6、不能在catch中使用泛型
 *        7、从泛型类派生子类，泛型类需具体化
 *
 *        把一个集合中的元素限定为特定的数据类型，就是泛型的核心思想
 */
public class GenericsTest {
    /*
     * 不使用泛型的问题：1、集合中任何类型的元素都可以添加进来
     *               2、在对集合元素进行强转时，容易出现类型转换异常
     */
    @Test
    public void test1(){
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        p1.setName("Tom");
        p1.setAge(4);

        p2.setName("Jerry");
        p2.setAge(2);

        p3.setName("Spike");
        p3.setAge(8);


        Student s1 = new Student();
        s1.setClassType("primary");
        s1.setClassName("2");
        s1.setHeadTeacher("David");
        s1.setName("Lily");
        s1.setAge(8);

        //集合中泛型的使用: 使用自定义对象作为泛型
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(s1);//集合中的泛型可以添加上溯造型的元素

        list.forEach(person -> {
            System.out.println("name = "+ person.getName() + ", age = " + person.getAge());
        });

        //使用默认的类型作为泛型：默认是Object类型
        List list2 = new ArrayList();
        list2.add("Tom, 4 years old.");
        list2.add(p2);
        list2.forEach(obj -> {
            System.out.println(obj.toString());
        });
    }

    //自定义泛型类、泛型接口、泛型方法,参照msc中BaseDao、BaseService的写法
    @Test
    public void test2(){
        PersonDao personDao = new PersonDao();
        Person p1 = new Person();
        p1.setAge(5);
        p1.setName("Mary");

        personDao.add(p1);
    }

}
