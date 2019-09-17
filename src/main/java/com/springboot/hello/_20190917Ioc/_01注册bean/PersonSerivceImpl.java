package com.springboot.hello._20190917Ioc._01注册bean;

public class PersonSerivceImpl implements PersonService {
    @Override
    public void saveUser() {
        System.out.println("add User...");
    }
}
