package com.springboot.hello._20190805ImmutableMap;

import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapBase {
    /**
     * 创建不可修改的map的几种方式
     * 之所以不可修改是因为
     *      所有变动元素的方法都给重写
     *      抛出不可修改异常
     *        public V put(K key, V value) {
     *             throw new UnsupportedOperationException();
     *         }
     */

    //1.Collections
    private final Map<String,Object> defaultMap = Collections.unmodifiableMap(new HashMap<>(8));

    //2.ImmutableMap
    private final Map<String,Object> guavaMap = ImmutableMap.copyOf(new HashMap<>(16));
}
