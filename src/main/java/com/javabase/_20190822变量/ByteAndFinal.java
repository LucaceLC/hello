package com.javabase._20190822变量;

import org.junit.jupiter.api.Test;

public class ByteAndFinal {

    @Test
    public void fucByte(){
        final byte firstNoValueByte,twoNoValueByte;
        final byte b2=3;
        final int b3 = 4;
        firstNoValueByte = b2 + b3;


        final int b4 = 124;
        twoNoValueByte = b2+b4;

        //byte的最大范围是-129 ～ 127
        byte maxByte = 127;
        byte minByte = -128;

    }

    @Test
    public void fucEnum(){
        OrderConstants.OrderStatus.OrderStatusEnum cancle = OrderConstants.OrderStatus.CANCLE;

//        OrderConstants.OrderStatus.CONFIRED;
    }

}