package com.springboot.hello._20200229设计模式._0402备忘录模式;

public class CareTaker {
    //责任人类

    private PersonMemo personMemo;

    public PersonMemo getPersonMemo() {
        return personMemo;
    }

    public void setPersonMemo(PersonMemo personMemo) {
        this.personMemo = personMemo;
    }
}
