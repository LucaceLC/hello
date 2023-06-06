package com.springboot.hello._2023060601JUC._2021030302锁关键字讲解;

public class App {}
class Syn{
    /**
     * synchronized锁关键字可以加在什么地方
     * 1锁代码块
     * 2修饰方法
     *    给静态方法上锁，这个时候，锁对象是Class
     *      无论是方法修饰符持有Class的锁
     *      如果是方法内部同步代码快，可以持有Class的锁，也可以持有静态对象Object的锁
     *
     *    给普通方法上锁，这个时候，锁对象是示例对象
     *      可以持有Class的锁，也可以持有this当前对象的锁
     */

    static App staticObject = new App();
    //对象锁
    public void bean(){
        synchronized (this){
        }
    }

    public static void staticMethod(){
        synchronized (App.class){
        }
    }


    //类锁
    public void clazz(){
        synchronized (App.class){
        }
    }

}