package com.javabase._20190911finally分析;

import org.junit.jupiter.api.Test;

public class FinallyTest {
    /**
     * try返回前，会保留好要返回的值，执行finally中的语句，finally三种情况：
     *
     *     一：有return语句，无论有没有修改返回值，都以finally的return的结果为准
     *
     *     二：没有return语句，无修改返回值，执行完finally{}语句后，try或catch中的return语句，返回之前保留的值。
     *
     *     三：没有return语句，修改了值，分基本数据类型/字符串 与其他引用数据类型两种情况：
     *
     *         1）return的是基本数据类型或文本字符串，代码修改return值不起作用，返回之前保留的值。
     *
     *         2）return的是除字符串的其他引用数据类型，代码修改return值起作用，返回修改后的数据。
     *
     * 在分析return的优先顺序
     *  明确三点
     *      1 finally的赋值是有效的
     *      2 finally的return的优先级是大于try/catch的return的
     *      3 如果方法有返回值，finally中定义了return语句后；后续不能写代码
     *
     */
    @Test
    public void fucFinnally(){
        int result = getBaseTypeWithReturn();
        System.out.println("getBaseTypeWithReturn result == " + result);

        result = getBaseTypeWithNoReturn();
        System.out.println("getBaseTypeWithNoReturn result == " + result);

        String strResult = getStringTypeWithNoReturn();
        System.out.println("getStringTypeWithNoReturn strResult == " + strResult);

        FinallyNumber finallyNumber = getReferenceTypeWithNoReturn();
        System.out.println("getReferenceTypeWithNoReturn finallyNumber == " + finallyNumber);

    }

    // 有return的情况  基本数据类型
    private int getBaseTypeWithReturn(){
        int baseReasult = 1;
        try {
            return baseReasult;
        }catch (Exception e){
            baseReasult ++;
            return baseReasult;
        }finally {
            baseReasult =  3;
            return baseReasult;
        }
    }

    //没有return，并且在finally中对基本类型进行修改
    private int getBaseTypeWithNoReturn(){
        int baseReasult = 1;
        try {
            return baseReasult;
        }catch (Exception e){
            baseReasult ++;
            return baseReasult;
        }finally {
            baseReasult =  3;
        }
    }
    //没有return，并且在finally中对String进行修改
    private String getStringTypeWithNoReturn(){
        String baseReasult = "1";
        try {
            return baseReasult;
        }catch (Exception e){
            return baseReasult;
        }finally {
            baseReasult += "1";
        }
    }

    //没有return，并且在finally中对引用类型进行修改
    private FinallyNumber getReferenceTypeWithNoReturn(){
        FinallyNumber finallyNumber = new FinallyNumber(1);
        try {
            return finallyNumber;
        }catch (Exception e){
            return finallyNumber;
        }finally {
            finallyNumber.setValue(2);
        }
    }
}
