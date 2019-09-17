package com.springboot.hello._20190804Guava.Splitter;

import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitterBase {

    //将字符串按规则切割, 默认是不跳过切割后的空值
    @Test
    public void fucDefaultSplitter(){
        List<String> defaultSplitterList = Splitter.on("|").splitToList("hello|world");
        assertEquals(defaultSplitterList.size(),2);
    }

    //omitEmptyStrings切割字符串时，跳过切割后为空的元素，不加入集合
    @Test
    public void fuctSplitterWithOmitEmpty(){
        List<String> defaultSplitterList = Splitter.on("|").omitEmptyStrings().splitToList("hello|world||||");
        assertEquals(defaultSplitterList.size(),2);
    }

    //trimResults掉集合元素两端的空格
    @Test
    public void fuctSplitterWithOmitEmptyWithTrimResult(){
        List<String> defaultSplitterList = Splitter.on("|").omitEmptyStrings().splitToList(" hello | world||||");
        assertEquals(defaultSplitterList.size(),2);
        assertEquals(defaultSplitterList.get(0)," hello ");
        assertEquals(defaultSplitterList.get(1)," world");

        List<String> trimResultSplitterList = Splitter.on("|").trimResults().omitEmptyStrings().splitToList(" hello | world||||");
        assertEquals(trimResultSplitterList.size(),2);
        assertEquals(trimResultSplitterList.get(0),"hello");
        assertEquals(trimResultSplitterList.get(1),"world");

    }
    //fixedLength按固定长度切割字符串
    @Test
    public void fucFixedLengthSplitter(){
        List<String> fixedSplitterList = Splitter.fixedLength(3).splitToList("aaabbbccc");
        assertEquals(fixedSplitterList.size(),3);
        fixedSplitterList.forEach(this::checkFixedLength);
    }
    private void checkFixedLength(String item){
        assertEquals(item.length(),3);
    }

    //limit限制字符串切割后的长度限制,将最后的字符串全部保留
    @Test
    public void fucLimitSplitter(){
        List<String> limitSplitterList = Splitter.on(",").limit(3).splitToList("hello,world,my,dear");
        assertEquals(limitSplitterList.size(),3);
        assertEquals(limitSplitterList.get(2),"my,dear");
    }

    //pattern表达式切割规则
    @Test
    public void fucPattern(){
        //onPattern正则表达式
        List<String> onPatternSplitterList = Splitter.onPattern("\\|").splitToList("hello|world|my|dear");
        assertEquals(onPatternSplitterList.size(),4);

        //没有匹配的不进行切割
        List<String> notSplitterList = Splitter.on("\\|").splitToList("hello|world|my|dear");
        assertEquals(notSplitterList.size(),1);

        //切割
        List<String> onSplitterList = Splitter.on("\\|").splitToList("hello\\|world\\|my\\|dear");
        assertEquals(onSplitterList.size(),4);

        //正则表达式编译
        List<String> patternCompileSplitterList = Splitter.on(Pattern.compile("\\|")).splitToList("hello|world|my|dear");
        assertEquals(patternCompileSplitterList.size(),4);
    }

    //map的切割
    @Test
    public void fucKeyValueSplitter(){
        Map<String, String> keyValueSplitterMap = Splitter.on("|").trimResults().omitEmptyStrings()
                .withKeyValueSeparator("=").split(" hello=HELLO | world=WORLD||||");

        assertEquals(keyValueSplitterMap.get("hello"),"HELLO");
        assertEquals(keyValueSplitterMap.get("world"),"WORLD");
        assertEquals(keyValueSplitterMap.size(),2);
    }
}
