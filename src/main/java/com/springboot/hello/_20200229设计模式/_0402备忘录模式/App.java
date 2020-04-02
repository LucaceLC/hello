package com.springboot.hello._20200229设计模式._0402备忘录模式;

import org.junit.jupiter.api.Test;

public class App {

    /**
     * 备忘录的使用场景
     *  悔棋，审批撤销
     *  事务回滚
     */
    @Test
    public void memoFumction(){
        //源对象
        Person person = new Person();
        person.setAge(18);
        person.setName("jack");
        System.out.println(person);

        //备忘录对象
        PersonMemo personMemo = person.memo();

        //责任人对对象
        CareTaker careTaker = new CareTaker();
        careTaker.setPersonMemo(personMemo);
        person.setAge(25);
        System.out.println(person);

        //恢复
        person.recovery(careTaker.getPersonMemo());
        System.out.println(person);

    }
}
