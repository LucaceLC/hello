package com.springboot.hello._20200104一种配置变量初始化的方法;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlConstants implements InitializingBean {

    @Value("${rpc.pay.url}")
    private String rpcPayUrl;

    public static String RPC_PAY_URL;

    @Override
    public void afterPropertiesSet() throws Exception {
        RPC_PAY_URL = rpcPayUrl;
    }
}
