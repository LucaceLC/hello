package com.springboot.hello._20190917Ioc._03验证bean作用域;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonSerivceImpl implements PersonService {

    @Autowired
    private Person person;

    @Override
    public void saveUser() {
        person.setName("新的名字");
        System.out.println("add User..." + person);
    }

    @Override
    public void updateUser() {
        System.out.println("update User.." + person);
    }
}
