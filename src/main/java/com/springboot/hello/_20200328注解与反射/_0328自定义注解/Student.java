package com.springboot.hello._20200328注解与反射._0328自定义注解;

@MyTable("tbl_student")
public class Student {

    @MyField(value = "student_name",fieldLength = 20,fieldType = "varchar")
    private String studentName;
    @MyField(value = "age",fieldLength = 3,fieldType = "int")
    private String age;

}
