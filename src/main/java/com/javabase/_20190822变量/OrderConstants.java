package com.javabase._20190822变量;

import java.util.HashMap;
import java.util.Map;

public interface OrderConstants {

    public class OrderStatus{
        public static final OrderStatusEnum CANCLE = OrderStatusEnum.CANCLE;
        public static final OrderStatusEnum CONFIRED = OrderStatusEnum.CONFIRED;

        public enum OrderStatusEnum {
            CANCLE(-1,"已取消"),CONFIRED(1,"已完成");
            private int value;
            private String message;

            private static final Map<String, OrderStatusEnum> mappings = new HashMap<>(16);

            static {
                for (OrderStatusEnum orderStatus : values()) {
                    mappings.put(orderStatus.name(), orderStatus);
                }
            }

            OrderStatusEnum(int value, String message) {
                this.value = value;
                this.message = message;
            }
        }
    }





}
