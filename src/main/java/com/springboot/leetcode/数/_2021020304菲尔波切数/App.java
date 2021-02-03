package com.springboot.leetcode.数._2021020304菲尔波切数;

public class App {

    /**
     * 菲尔波切数
     * f(N) = f(N-1) + f(N-2)
     *
     * 递归
     * 动态规划
     * 动态偏移
     */
    public int fib1(int N){
        if(N == 0 || N == 1) return N;
        return fib1(N-1) + fib1(N-2);
    }

    /**
     * 动态规划，空间换时间
     *
     * 状态容器，初始化，状态转移方程 返回结果
     */
    public int fib2(int N){
        if(N == 0 || N == 1) return N;
        int[] init = new int[N + 1];
        init[0] = 0;
        init[1] = 1;
        for (int i=2; i <= N; i++){
            init[i] = init[i-1] + init[i-2];
        }
        return init[N];
    }

    /**
     * 动态规划，偏移量
     */
    public int fib3(int N){
        if(N == 0 || N == 1) return N;
        int pre1=0;
        int pre2=1;
        int result = 0;
        for (int i=2; i <= N; i++){
            result = pre1 +pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
