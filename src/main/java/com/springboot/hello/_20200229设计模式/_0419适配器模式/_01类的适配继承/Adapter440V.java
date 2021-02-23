package com.springboot.hello._20200229设计模式._0419适配器模式._01类的适配继承;


//把一个电源的220V，适配到550V上
public class Adapter440V extends OutPower220V implements TargetOutPower550V {

    @Override
    public int convert440V() {
        return super.out() * 2;
    }
}
