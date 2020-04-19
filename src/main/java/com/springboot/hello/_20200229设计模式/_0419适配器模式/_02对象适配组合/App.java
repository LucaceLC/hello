package com.springboot.hello._20200229设计模式._0419适配器模式._02对象适配组合;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void classAdapterFunction() {
        AC220V ac220V = new AC220V();
        AdapterCovert5V adapterCovert5V = new AdapterCovert5V(ac220V);

        int powerInt  = adapterCovert5V.covert5V();
        Assertions.assertEquals(powerInt,5);

    }
}
