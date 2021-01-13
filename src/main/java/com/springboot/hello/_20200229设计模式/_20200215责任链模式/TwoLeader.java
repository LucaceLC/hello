package com.springboot.hello._20200229设计模式._20200215责任链模式;

public class TwoLeader extends Leader {

    public TwoLeader(String name){
        super(name);
    }

    @Override
    protected void handleRequest(LeaveRequest leaveRequest) {
        if(1<leaveRequest.getLeaveDays() && leaveRequest.getLeaveDays()<=10){
            System.out.println("二级领导的审批权限  1到10天");
        }
        else {
            nextLeader.handleRequest(leaveRequest);
        }
    }
}
