package com.springboot.hello._20200229设计模式._0420桥接模式;

public class Computer {

    private Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public String sale(){
        String format = String.format("销售%s电脑", brand.showBrandName());
        return format;
    }
}

class DesktopComputer extends Computer{

    public DesktopComputer(Brand brand) {
        super(brand);
    }
    @Override
    public String sale() {
        String brandName = super.sale();
        String computerType  = "台式机";
        System.out.println(String.format("%s:%s",computerType,brandName));
        return null;
    }
}

class NotebookComputer extends Computer{

    public NotebookComputer(Brand brand) {
        super(brand);
    }

    @Override
    public String sale() {
        String brandName = super.sale();
        String computerType  = "笔记本";
        System.out.println(String.format("%s:%s",computerType,brandName));
        return null;
    }
}
