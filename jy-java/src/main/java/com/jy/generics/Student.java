package com.jy.generics;

public class Student extends Person {
    /**
     * 年级
     */
    private String classType;

    /**
     * 班别
     */
    private String className;

    /**
     * 班主任
     */
    private String headTeacher;

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher;
    }
}
