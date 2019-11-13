package com.springboot.hello._20191112访问控制权与Import._20191112Import命名空间;

import org.junit.jupiter.api.Test;

public class ImportApp {
    /**
     * import
     * 作用：引用命名空间
     *      1、全包名，具体引用
     *      2、*
     *      3、使A命名空间的类拥有B命名空间的类的访问权限
     *      4、允许一个项目的类同名，前提是在不同命名空间下
     */

    //同包下User
    @Test
    public void importWithPackageFuc(){
        User user = new User();
    }

    //非同包下User
    @Test
    public void importWithNoPackageFuc(){
        com.springboot.hello._20191112访问控制权与Import._20191112Import命名空间.extend.User  user  =
                new com.springboot.hello._20191112访问控制权与Import._20191112Import命名空间.extend.User();
    }
}
