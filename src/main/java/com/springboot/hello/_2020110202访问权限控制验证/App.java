package com.springboot.hello._2020110202访问权限控制验证;

public class App {

    public static void main(String[] args) {
        ProjectedClass projectedClass = new ProjectedClass();
        //print方法是protected级别，仅，子类，同包下可以访问
        projectedClass.print();
    }
}
