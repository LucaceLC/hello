package com.springboot.hello._20200215责任链模式;

public class ThreeLeader extends Leader {

    public ThreeLeader(String name) {
        super(name);
    }

    @Override
    protected void handleRequest(LeaveRequest leaveRequest) {
        if(leaveRequest.getLeaveDays()>10){
            System.out.println("第三级别领导审批权限");
        }
    }
}
