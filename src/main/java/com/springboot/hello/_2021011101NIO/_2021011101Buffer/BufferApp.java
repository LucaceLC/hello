package com.springboot.hello._2021011101NIO._2021011101Buffer;

import org.junit.jupiter.api.Test;

import java.nio.*;

public class BufferApp {

    @Test
    public void bufferType(){
        /**
         * buffer的数据类型，除去boolean外，每一种基础数据类型都有对应的buffer
         *
         * 基本数据类型的buffer操作方式相同，都是通过allocate(容量)创建获取缓冲区
         */
        ByteBuffer.allocate(1024);
        CharBuffer.allocate(1024);
        ShortBuffer.allocate(1024);
        IntBuffer.allocate(1024);
        LongBuffer.allocate(1024);
        FloatBuffer.allocate(1024);
        DoubleBuffer.allocate(1023);
    }

    @Test
    public void bufferUsing(){
        /**
         * 缓冲区的重要属性
         *  容量：capacity
         *  限制：limit
         *  位置 position
         *  手动标记点 mark
         *
         */
        String hello = "Hello World"; //10个字符
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(hello.getBytes());

        //写入数据: buffer.put
        System.out.println("position=" + buffer.position());
        System.out.println("capacity=" + buffer.capacity());
        System.out.println("limit=" + buffer.limit());

        //切换到读模式 buffer.flip()
        buffer.flip();
        System.out.println("position=" + buffer.position());
        System.out.println("capacity=" + buffer.capacity());
        System.out.println("limit=" + buffer.limit());

        //获取数据
        byte[] result = new byte[buffer.limit()];
        buffer.get(result);
        System.out.println(new String(result));

        //重新倒带缓冲区，重置位置
        buffer.rewind();
        System.out.println("position=" + buffer.position());
        System.out.println("capacity=" + buffer.capacity());
        System.out.println("limit=" + buffer.limit());

        //清空缓冲区，但是缓冲区的数据依然存在，只是在"被遗忘状态"
        buffer.clear();
        System.out.println("position=" + buffer.position());
        System.out.println("capacity=" + buffer.capacity());
        System.out.println("limit=" + buffer.limit());
    }

    @Test
    public void bufferMarkTest(){

    }
}
