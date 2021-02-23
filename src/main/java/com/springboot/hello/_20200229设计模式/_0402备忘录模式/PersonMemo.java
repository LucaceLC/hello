package com.springboot.hello._20200229设计模式._0402备忘录模式;

import lombok.ToString;

@ToString
public class PersonMemo {


    private String name;
    private Integer age;

    //备忘录类 的构造器是用数据源类创建的
    public PersonMemo(Person person){
        this.name = person.getName();
        this.age = person.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
