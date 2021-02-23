package com.springboot.hello._20200229设计模式._0420桥接模式;

import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void bridgeModelWithFunction() {

        /**
         * 桥接模式，
         * 条件，描述多个纬度，替换掉多继承描述
         */
        Computer lenovoDesktopComputer = new DesktopComputer(new Lenovo());
        Computer hpDesktopComputer = new DesktopComputer(new Hp());
        Computer acearDesktopComputer = new DesktopComputer(new Acear());
        lenovoDesktopComputer.sale();
        hpDesktopComputer.sale();
        acearDesktopComputer.sale();

        Computer lenovoNotebookComputer = new NotebookComputer(new Lenovo());
        Computer hpNotebookComputer = new NotebookComputer(new Hp());
        Computer acearNotebookComputer = new NotebookComputer(new Acear());
        lenovoNotebookComputer.sale();
        hpNotebookComputer.sale();
        acearNotebookComputer.sale();


    }
}
