package com.springboot.hello._2023060601JUC._2021022201LockSupport讲解._004SupportLock面试题;

public class App {
    /**
     * 为什么唤醒两次后阻塞两次，单最终结果还会阻塞线程
     *      因为SupportLock 调用unpark时，会方法一个许可证，permit，许可证的上限为1，即使unpark两次
     *      permit 也等于1，调用park消费凭证，permit-1，第二次park时，无法获取到凭证，线程阻塞
     *
     * 为什么可以先唤醒线程后阻塞线程
     *      因为SupportLock为线程设置了许可凭证，permit，调用unpark发放了一个凭证，之后调用park方法，
     *      消费凭证即可，线程不会被阻塞
     */
}
