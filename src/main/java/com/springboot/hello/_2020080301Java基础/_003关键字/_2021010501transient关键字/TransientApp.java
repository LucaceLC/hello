package com.springboot.hello._2020080301Java基础._003关键字._2021010501transient关键字;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.*;

public class TransientApp {

    /**
     * transient关键字：被修饰的成员变量不能被序列化，前提是类实现序列化接口，没实现会报错，java.io.NotSerializableException
     *                静态变量从属于类，无论是否修饰transient，都不会被序列化
     *
     *  场景：序列化，网络传输
     */
    @Test
    public void testTransient() throws Exception{
        Rectangle rectangle = new Rectangle(1, 2);
        System.out.println(rectangle);

        //序列化
        FileOutputStream fileOutputStream = new FileOutputStream("old_rectangle");
        ObjectOutputStream ops = new ObjectOutputStream(fileOutputStream);
        ops.writeObject(rectangle);
        ops.close();


        //反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("old_rectangle"));
        Rectangle newRectangle = (Rectangle) in.readObject();
        System.out.println(newRectangle);

        newRectangle.setArea();
        System.out.println(newRectangle);
    }
}


@Data
class Rectangle implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double width;
    private Double height;

    private transient Double area;

    public void setArea(){
        this.area = width * height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}
