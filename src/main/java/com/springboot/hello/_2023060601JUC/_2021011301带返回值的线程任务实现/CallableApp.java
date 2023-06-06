package com.springboot.hello._2023060601JUC._2021011301带返回值的线程任务实现;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableApp {

    @SneakyThrows
    @Test
    public void 带返回值的线程任务实现(){
        /**
         *  带返回值的线程任务
         *  需要指定Callable泛型
         *  用Future实现类接受，FutureTask是其中之一
         *  线程执行传入Future
         *  执行结果future.get获取
         *
         *  性质-类似闭锁，主线程会等待线程执行完毕，才继续执行
         */

        CallableRunnable callableRunnable = new CallableRunnable();
        FutureTask<Integer> future = new FutureTask<>(callableRunnable);
        new Thread(future).start();
        Integer result = future.get();
        System.out.println(result);
    }
}

class CallableRunnable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        return sum;
    }
}