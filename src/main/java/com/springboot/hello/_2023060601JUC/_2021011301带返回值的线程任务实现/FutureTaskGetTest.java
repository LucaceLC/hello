package com.springboot.hello._2023060601JUC._2021011301带返回值的线程任务实现;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskGetTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            Thread.sleep(3000);
            return "等待了3秒";
        });
        singleThreadExecutor.submit(futureTask);
        System.out.println("真的等待了3s后，才异步的获取到执行结果" + futureTask.get());
        System.out.println("我不会被先执行");
        singleThreadExecutor.shutdown();
    }
}