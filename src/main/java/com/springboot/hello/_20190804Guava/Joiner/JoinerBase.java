package com.springboot.hello._20190804Guava.Joiner;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class JoinerBase {
    private final List<String> defaultList = Arrays.asList("java","go","php");
    private final List<String> defaultWithNullList = Arrays.asList("java","go","php",null);
    //不可变map的key value 都不能为null
    private final Map<String,Object> defaultMap = ImmutableMap.of("key1","value1","key2","value2");

    @Test
    public void fucDefaultList(){
        //默认构造不能将null拼接在后面,抛出空指针异常
        String defaultStr = Joiner.on("#").join(defaultList);

        assertEquals(defaultStr,"java#go#php");
    }

    //跳过null不拼接
    @Test()
    public void fucDefaultWithNullList(){
        String defaultNotNullStr = Joiner.on("#").skipNulls().join(defaultWithNullList);

        assertEquals(defaultNotNullStr,"java#go#php");
    }

    //null值使用默认值替换
    @Test()
    public void fucNullForDefaultValueList(){
        String defaultNotNullStr = Joiner.on("#").useForNull("default").join(defaultWithNullList);

        assertEquals(defaultNotNullStr,"java#go#php#default");
    }

    //生成的str追加在StringBuilder上，并且是返回原StrungBuilder,指的是同一个对象
    @Test()
    public void fucWithStringBuilder(){
        //也可以拼接在文件上，如果没有创建一个文件
        final StringBuilder defaulStrBuilder = new StringBuilder();
        StringBuilder stringBuilder = Joiner.on("#").useForNull("default").appendTo(defaulStrBuilder, defaultWithNullList);

        assertSame(defaulStrBuilder,stringBuilder);
    }

    //使用stream过滤集合，然后以字符拼接。且如果存在null值，用default值替换
    @Test()
    public void fucStreamSkipNull(){
        String streamList = defaultWithNullList.stream().map(this::setNullDefault).collect(joining("#"));
        assertEquals(streamList,"java#go#php#default");
    }

    //使用函数推导的方式重构
    private String setNullDefault(String item){
        return StringUtils.hasLength(item) ? item : "default";
    }


    //对于map的结构，进行拼接
    @Test
    public void fucDefaultMap(){
        String mapStr = Joiner.on("#").withKeyValueSeparator("=").join(defaultMap);
        assertEquals(mapStr,"key1=value1#key2=value2");
    }

}
