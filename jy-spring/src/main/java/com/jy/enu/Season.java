package com.jy.enu;

/**
 * 枚举类
 */
public enum Season implements SeasonShow{

    //在枚举类的内部实例化对象
    spring("spring","春天"){
        @Override
        public void show() {
            System.out.println("四季如春");
        }
    },
    summer("summer","夏天"){
        @Override
        public void show() {
            System.out.println("生如夏花");
        }
    },
    autumn("autumn","秋天"){
        @Override
        public void show() {
            System.out.println("秋高气爽");
        }
    },
    winter("winter","冬天"){
        @Override
        public void show() {
            System.out.println("凛冬将至");
        }
    };

    private final String name;
    private final String description;

    private Season(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
