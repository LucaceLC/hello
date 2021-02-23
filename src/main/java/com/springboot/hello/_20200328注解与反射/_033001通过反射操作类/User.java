package com.springboot.hello._20200328注解与反射._033001通过反射操作类;

public class User {

    private String userName;
    private Long id;

    public User() {
    }

    public User(Long id,String userName) {
        this.userName = userName;
        this.id = id;
    }

    private void setDefaultUserName() {
        this.id = -1L;
        this.userName = "defaultUserName";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                '}';
    }
}
