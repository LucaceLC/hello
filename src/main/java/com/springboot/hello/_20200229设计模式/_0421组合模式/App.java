package com.springboot.hello._20200229设计模式._0421组合模式;

import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void combinationMode() {
        /**
         * 存在树型结构
         *
         * 组合模式天然具有递归的属性，容器构件和叶子构件拥有统一的行为
         */
        MoviesFile moviesFile = new MoviesFile();
        TextFile textFile = new TextFile();
        moviesFile.killVirus();
        textFile.killVirus();

        System.out.println("------分割线--------");
        ContainerFile containerFile = new ContainerFile();
        containerFile.addFile(moviesFile);
        containerFile.addFile(textFile);

        containerFile.killVirus();

    }
}
