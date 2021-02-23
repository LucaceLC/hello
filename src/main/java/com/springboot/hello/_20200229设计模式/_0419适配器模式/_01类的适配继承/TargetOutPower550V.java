package com.springboot.hello._20200229设计模式._0419适配器模式._01类的适配继承;

public interface TargetOutPower550V {

    /**
     * 1适配器的功能是什么，那么Target就是什么，适配的最终目的
     * 2具体的适配器，会实现这个Target功能，要满足最终目的
     * 3被适配者
     */
    int convert440V();
}
