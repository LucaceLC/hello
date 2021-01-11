package com.springboot.hello._2020121801JDK14新特性测试;

import org.springframework.util.StringUtils;

public class instanceof模式匹配 {

    public static void main(String[] args) {
        instanceof模式匹配 app = new instanceof模式匹配();
        app.jdk8();
        app.jdk14();

        Object obj = new String("hello world");
        app.jdk14Boolean(obj);

    }

    private void jdk8(){
        Object obj = new String("hello world");
        if(obj instanceof String){
            String str = (String) obj;
            System.out.println("String:"+str);
        }else {
            System.out.println("其他类型");
        }
    }


    private void jdk14(){
        Object obj = new String("hello world");
        if(obj instanceof String str){
            System.out.println("String:"+str);
        }else {
            System.out.println("其他类型");
        }
    }

    private Boolean jdk14Boolean(Object obj){
        boolean result = obj instanceof String str && !StringUtils.isEmpty(str);
        System.out.println(result);
        return result;
    }
}
