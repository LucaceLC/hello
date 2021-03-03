package com.springboot.hello._20190917Ioc._2021022402Spring的生命周期;

public class App {

    public static void main(String[] args) {
        /**
         * bean的生命周期
         * new 一个实例
         * bean的初始化，用以bean创建前的准备
         *
         * bean的销毁，用户清除资源
         *  要求1 在bean的作用域为单例的前提下，关闭容器时，才会调用bean的销毁方法，进行销毁
         *  要求2 如果bean的作用域是原型的，容器关闭，bean不会被销毁
         */

        /**
         * BeanPostProcessors
         * Spring的后置处理器
         * 本身是一个全局的处理器，所有实例都会经过处理器
         *
         * 有两个方法，初始化之前，初始化之后调用
         * postProcessBeforeInitialization 在初始化之前调用
         * postProcessAfterInitialization  在初始化之后调用
         *
         * eg:
         *  处理特定类型的实例，获取类的所有属性，然后获取注解，进行特殊处理
         *      if (bean instanceof Cat) {
         *             //输出原始属性
         *             Cat cat = (Cat) bean;
         *             cat.say();
         *             return bean;
         *         }
         *
         *     Annotation[] annotations = bean.getClass().getAnnotations();
         *         Stream.of(annotations).forEach(annotation -> {
         *             if(annotation instanceof Data){
         *                 System.out.printf("有@Data注解");
         *             }
         *         });
         *         return bean;
         * 后置处理起的过程
         *
         * A a = new A();
         * a = beanPostProcessors.before(a)
         * a.init();
         * a = beanPostProcessors.after(a);
         * a.destroy();
         */
    }

}
