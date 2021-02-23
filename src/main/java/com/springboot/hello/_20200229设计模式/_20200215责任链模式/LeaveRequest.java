package com.springboot.hello._20200229设计模式._20200215责任链模式;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaveRequest {
    private String name;
    private Integer leaveDays;
    private String  memo;

}
