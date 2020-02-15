package com.springboot.hello._20200215责任链模式;

import lombok.Data;

@Data
public class OneLeader extends Leader {

    public OneLeader(String name){
        super(name);
    }


    @Override
    protected void handleRequest(LeaveRequest leaveRequest) {

        /**
         * 模拟  <1 天  1级领导审批
         *      1，10天 2级领导审批
         *      >10天  3级领导审批
         */
        if(leaveRequest.getLeaveDays()<=1){
            System.out.println("一级领导审批，权限1天内");
        }
        else {
            nextLeader.handleRequest(leaveRequest);
        }
    }
}
