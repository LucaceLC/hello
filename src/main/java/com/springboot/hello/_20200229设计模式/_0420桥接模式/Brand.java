package com.springboot.hello._20200229设计模式._0420桥接模式;

public interface Brand {
    String showBrandName();
}

class Lenovo implements Brand {

    @Override
    public String showBrandName() {
        return "联想";
    }
}

class Hp implements Brand {

    @Override
    public String showBrandName() {
        return "惠普";
    }
}

class Acear implements Brand {

    @Override
    public String showBrandName() {
        return "宏基";
    }
}