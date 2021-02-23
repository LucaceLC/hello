package com.springboot.hello._20200229设计模式._20200215责任链模式;

import lombok.Data;

@Data
public abstract class Leader {
    /**
     * 作为顶层的抽象对象，子类对象必须实现handleRequest方法
     */
    private String name;
    protected Leader nextLeader;

    public Leader(String name){
        this.name = name;
    }

    protected abstract void handleRequest(LeaveRequest leaveRequest);
}
