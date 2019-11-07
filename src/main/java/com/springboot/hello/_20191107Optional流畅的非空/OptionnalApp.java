package com.springboot.hello._20191107Optional流畅的非空;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 * Optional代码练习
 * </p>
 *
 * @See https://www.cnblogs.com/zhangboyu/p/7580262.html
 * @Author luoc20
 */

public class OptionnalApp {

    @Test
    public void optionalFuc() {
        /**
         * 为什么使用Optional
         * 1目的：解决臭名昭著的空指针异常问题
         * 2流畅的链式调用
         *
         * API详解：
         * 1、empty()方法一定是返回一个空的Optional，value是null
         * 2、get方法当且仅能获取非空value，否则报异常：java.util.NoSuchElementException: No value present
         * 3、isEmpty()可以判断是否有值
         */

        var userOptional = Optional.empty();
        assertThrows(NoSuchElementException.class, () -> userOptional.get());
    }

    @Test
    public void createOptionalFuc() {
        /**
         * 构建Optional的几种方式
         * 1 of()方法，不允许value=null;
         * 2 ofNullable(),允许value=null;
         */
        User user = createuser();
        User userNUll = null;

        Optional<User> ofOptional = Optional.of(user);
        Optional<User> ofNullableOptional = Optional.ofNullable(user);

        assertDoesNotThrow(() -> Optional.ofNullable(userNUll));

        assertThrows(NullPointerException.class, () -> Optional.of(userNUll));
    }

    private User createuser() {
        return new User().setEmail("@gmiil.com").setName("jack");
    }

    private Optional<User> createUserOptional() {
        User user = createuser();
        Optional<User> optional = Optional.ofNullable(user);
        return optional;
    }

    private Optional<User> createUserOptionalWithNull() {
        return Optional.ofNullable(null);
    }

    @Test
    public void getValueWithOptional() {
        /**
         * 显然的，value=null时 get()NoSuchElementException
         * 1、使用get()时，默认值方法替代
         * 2、isPresent判断值是否存在，如果存在，还可以使用消费者多态方法，记性value的处理
         */
        User user = createuser();
        Optional<User> optional = Optional.ofNullable(user);

        boolean isPresent = optional.isPresent();
        boolean isEmpty = optional.isEmpty();

        assertEquals(true, isPresent);
        assertEquals(false, isEmpty);
    }

    @Test
    public void ifPresentFuc() {
        /**
         * 1、ifPresent如果value值存在，则干什么
         */
        Optional<User> userOptional = createUserOptional();
        userOptional.ifPresent(user -> assertEquals("jack", user.getName()));
    }

    @Test
    public void orElseFuc() {
        /**
         * 虽然orElse()方法设置了缺省值，get()方法也能获取到缺省值，但是对了Optional本身来说，它的value是null；
         * 源码
         * this.value != null ? this.value : other;
         *
         */
        Optional<User> userOptional = createUserOptionalWithNull();
        User user = userOptional.orElse(new User().setEmail("@163.com").setName("luce"));

        assertEquals(true, userOptional.isEmpty());
        assertEquals("luce", user.getName());
    }

    @Test
    public void orElseGetFuc() {
        /**
         * orElseGet与orElse的区分
         * this.value != null ? this.value : supplier.get();
         *
         * 1、orElse无论value是否为null；都会构造缺省值/默认值，此处的默认值是作为必要参数传入的
         * 2、orElseGet只有在value=null时，才会调用生产者构造，利用的是逻辑的判断，为nul -> supplier.get();
         * 3、assertThrows 如果value ！=null 返回value值，否则抛出异常，
         *      默认是NoSuchElementException，也可以自定义抛出异常类型
         */

        Optional<User> userOptionalWithNull = createUserOptionalWithNull();
        User luceUser = userOptionalWithNull.orElse(new User().setEmail("@163.com").setName("luce"));
        User jackUser = userOptionalWithNull.orElseGet(() -> createUserOptional().get());

        assertThrows(NoSuchElementException.class, () -> userOptionalWithNull.orElseThrow());

        assertThrows(IllegalArgumentException.class,
                () -> userOptionalWithNull.orElseThrow(
                        () -> new IllegalArgumentException("value is null throw new IllegalArgumentException")));
    }

    @Test
    public void mapWithOptional() {
        /**
         * 在get()方法，允许value=null；
         */

        Optional<User> userOptional = createUserOptional();
        String userName = userOptional.map(User::getName).get();
        assertEquals("jack", userName);


        Optional<User> userOptionalWithNull = createUserOptionalWithNull();
        String newUserName = userOptionalWithNull.map(User::getName).orElseGet(() -> "default userName");
        String newUserName2 = userOptionalWithNull.map(User::getName).orElse("default userName");
        assertEquals("default userName", newUserName);
        assertEquals(newUserName2, newUserName);
    }

    @Test
    public void flatMapWithOptional() {

        /**
         * flatmap的参数Fuction必须是Optional包装类型的
         */
        Optional<User> userOptional = createUserOptionalWithNull();
        String userName = userOptional.flatMap(u -> Optional.ofNullable(u.getName())).orElseGet(() -> "default Name");
        assertEquals("default Name", userName);
    }


    //链式调用的优点
    @Test
    public void flatMapWithOptionalCopy() {
        /**
         * flatMap的链式调用，必须要是统一的Optional包装类
         */
        Optional<User> userOptional = createUserOptional();
        String countryName = userOptional
                .flatMap(User::getAddress)
                .flatMap(Address::getUserAddress)
                .orElse("default");
        assertEquals("deault", countryName);
    }

    @Test
    public void mapWithOptionalCopy() {
        /**
         * 链式调用使用map比较方便，同时可以防止空指针的出现
         */
        Optional<User> userOptional = createUserOptional();

        Long userMoneyNumber = userOptional
                .map(User::getMoneyNumber)
                .map(Money::getMoneyNumber)
                .orElseGet(() -> 10L);

        assertEquals(10L, userMoneyNumber.longValue());
    }

    //Optional的过滤和stream的过滤有异曲同工之妙
    @Test
    public void filterOptional() {
        Optional<User> userOptional = createUserOptional();
        //过滤掉不符合条件User,和Stream的特殊之处是单个对象的过滤
        String userName = userOptional.filter(user -> user.getName().equals("jack")).map(User::getName).orElseGet(() -> "default");
        assertEquals("jack", userName);

        String userNameWithNew = userOptional.filter(user -> user.getName().equals("luce")).map(User::getName).orElseGet(() -> "default");
        assertEquals("default", userNameWithNew);
    }

    //or(）返回的是Optional的包装类，而orElse、orElseGet返回的是引用类型
    @Test
    public void orFuc() {
        Optional<User> userOptionalWithNull = createUserOptionalWithNull();
        User user = userOptionalWithNull.or(() -> Optional.of(new User().setName("default"))).get();
        assertEquals("default", user.getName());
    }

    @Test
    public void ifPresentOrElseFuc() {
        /**
         * ifPresentOrElse 其实是一个分支选择方法,没有返回值
         *
         * 作为一种分支结构使用，挺方便的，链式调用
         */
        createUserOptional().ifPresentOrElse(System.out::println, () -> System.out.println("not found user"));

        createUserOptionalWithNull().ifPresentOrElse(System.out::println, () -> System.out.println("not found user"));
    }

    //单个对象转换成stream然后进行集合化
    @Test
    public void streamWithOptional() {
        List<String> userNameList = createUserOptional()
                .or(() -> Optional.of(new User().setName("default")))
                .stream().map(User::getName).collect(Collectors.toList());
        assertEquals(1, userNameList.size());
        assertEquals("jack", userNameList.get(0));


        List<String> userNameListWithNew = createUserOptionalWithNull()
                .or(() -> Optional.of(new User().setName("default")))
                .stream().map(User::getName).collect(Collectors.toList());
        assertEquals(1, userNameListWithNew.size());
        assertEquals("default", userNameListWithNew.get(0));
    }

    //Optional主要作为返回值的类型，如果为空的替代行为，进行链式编程的有效手段s
}
