package com.springboot.hello._20200215责任链模式;

import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void testFunction(){
        /**
         * 责任链模式
         * 是一种行为设计模式 采用责任链模式的每一级的权限范围是明确的，清晰的
         *
         * 层层相扣
         * 上级关系在客户端进行设定
         */

        Leader oneLeader = new OneLeader("一级领导");
        Leader twoLeader = new TwoLeader("二级领导");
        Leader threeLeader = new ThreeLeader("一级领导");
        oneLeader.setNextLeader(twoLeader);
        twoLeader.setNextLeader(threeLeader);

        LeaveRequest leaveRequest = new LeaveRequest("Jack",1,"请加1天");
        LeaveRequest leaveRequest2 = new LeaveRequest("Tom",5,"请加1天");
        LeaveRequest leaveRequest3 = new LeaveRequest("Lucas",11,"请加1天");

        oneLeader.handleRequest(leaveRequest);
        oneLeader.handleRequest(leaveRequest2);
        oneLeader.handleRequest(leaveRequest3);
    }
}
