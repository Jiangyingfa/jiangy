package com.jy.generics;

/**
 * 自定义泛型类的使用
 */
public class PersonDao extends BaseDao<Person> {

    @Override
    public Person add(Person person) {
        System.out.println("调用泛型类中的add方法     name=" + person.getName() + ",age=" + person.getAge());
        return super.add(person);
    }

    @Override
    public Person update(Person person) {
        return super.update(person);
    }

    @Override
    public void getById(Long id) {
        super.getById(id);
    }

    @Override
    public void delete(Person person) {
        super.delete(person);
    }


}
