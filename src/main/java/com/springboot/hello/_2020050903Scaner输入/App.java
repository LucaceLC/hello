package com.springboot.hello._2020050903Scaner输入;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入姓名");
        String name = scanner.nextLine();
        System.out.println("输入年龄");
        String age = scanner.nextLine();
        System.out.println("输入职业");
        String job = scanner.nextLine();

        System.out.println("信息汇总" + name + "," + age + "," + job);
    }
}
