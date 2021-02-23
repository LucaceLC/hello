package com.springboot.hello._20200229设计模式._0419适配器模式._02对象适配组合;

public class AdapterCovert5V implements Covert5V {

    private AC220V ac220V;

    @Override
    public int covert5V() {
        return ac220V.outPower220V() / 24;
    }

    public AdapterCovert5V(AC220V ac220V){
        this.ac220V = ac220V;
    }
}
