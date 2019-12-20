package com.springboot.hello._20191217反射机制._201912192001获取类的属性方法;

public class User {
    private Long id;
    private String name;

    public String publicVariable;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicVariable() {
        return publicVariable;
    }

    public void setPublicVariable(String publicVariable) {
        this.publicVariable = publicVariable;
    }
}
