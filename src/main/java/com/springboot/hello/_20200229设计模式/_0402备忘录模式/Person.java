package com.springboot.hello._20200229设计模式._0402备忘录模式;

import lombok.ToString;

@ToString
public class Person{

    private String name;
    private Integer age;

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


    public PersonMemo memo(){
        return new PersonMemo(this);
    }

    public void recovery(PersonMemo personMemo){
        this.age = personMemo.getAge();
        this.name = personMemo.getName();
    }
}

