package com.springboot.hello._20190917Ioc._062021022501spring属性注入;

public class App {
    //依赖注入是手段，控制反转是目的
    public static void main(String[] args) {
        /**
         * spring xml配置
         * 在bean实例化的时候，进行属性注入
         *
         * 1 调用构造器注入属性，构造器标签
         *                   ref对应属性名，value对应值
         *                   index 按属性位置从0开始，注入valur，必须实现有参构造器，多个有参构造器调用第一个
         *                   type 可以指定类型
         * 2 setter方法注入属性，property属性标签，按name属性名，value值注入
         *
         * 3p命名空间 引入xmlns:p命名空间
         * <bean p:属性名=值，p:引用类型属性名-ref=值></bean>
         *
         * 4SpEL表达式 #{}
         *
         * 5集合注入 List Array Map Property都有对应的标签进行xml配置
         *
         */

        /**
         * 注解注入属性，同样的，可以在构造器，属性，上进行注解注入
         *
         * 初始化方法注解@PostConstruct 销毁注解@PreDestroy
         *
         * 1前提，必须在Spring包扫描下@Configuration @CompentSacn
         * @Compent 组件注解
         * @Repository dao层
         * @Service service层
         * @Controller
         * @RestControlelr 控制层
         *
         * 2属性注入
         * @Value 属性注入
         * @Autowire 引用变量依赖注入  按类型注入，默认按名称首字母小写注入
         * @Qualifier call了fi儿，别名，多个相同类型的bean，按别名选择注入
         * @Resource 按名称注入，首字母小写
         */


    }
}
