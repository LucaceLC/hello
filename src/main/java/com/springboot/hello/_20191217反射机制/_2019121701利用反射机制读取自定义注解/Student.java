package com.springboot.hello._20191217反射机制._2019121701利用反射机制读取自定义注解;

@Table("tbl_student")
public class Student {

    @Field(value = "id",fieldType = "bigint",fieldLength = 20)
    private Integer id;
    @Field(value = "name",fieldType = "varchar",fieldLength = 20)
    private String name;
    @Field(value = "age",fieldType = "tinyint",fieldLength = 20)
    private Integer age;
}
