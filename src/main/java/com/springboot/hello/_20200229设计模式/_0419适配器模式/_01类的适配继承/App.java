package com.springboot.hello._20200229设计模式._0419适配器模式._01类的适配继承;

import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void adapterFunction(){
        //创建一个适配器,适配550V
        Adapter440V adapter440V = new Adapter440V();
        int i = adapter440V.convert440V();
        System.out.println(i);

    }
}
