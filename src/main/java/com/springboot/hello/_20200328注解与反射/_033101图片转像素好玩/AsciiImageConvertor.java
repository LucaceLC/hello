package com.springboot.hello._20200328注解与反射._033101图片转像素好玩;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 图片转ASCII字符画
 * 代码翻译自Python版本 http://www.jianshu.com/p/e8152f14904a
 * @author jzhung.com
 */
public class AsciiImageConvertor {
    // 一个字符对应一段灰度范围
    private static char[] charTable = {'$', '@', 'B', '%', '8', '&', 'W', 'M', '#', '*', 'o', 'a', 'h', 'k', 'b', 'd', 'p', 'q', 'w', 'm', 'Z', 'O', '0', 'Q', 'L', 'C', 'J', 'U', 'Y', 'X', 'z', 'c', 'v', 'u', 'n', 'x', 'r', 'j', 'f', 't', '/', '\\', '|', '(', ')', '1', '{', '}', '[', ']', '?', '-', '_', '+', '~', '<', '>', 'i', '!', 'l', 'I', ';', ':', ',', '"', '^', '`', '\'', '.', ' '};

    public static void main(String[] args) {
        String srcFile = "/Users/shanyuefengcheng/Desktop/梅花2.jpg";
        String dstFile = "/Users/shanyuefengcheng/Desktop/3.txt";
        int simpleSize = 10; //采样像素间隔 数值越大图像越小，精度越差
        buildAsciiImage(srcFile, dstFile, simpleSize);
    }

    /**
     * 创建ASCII字符画
     *
     * @param file
     * @param dstFile
     * @param simpleSize
     */
    public static void buildAsciiImage(String file, String dstFile, int simpleSize) {
        File srcFile = new File(file);

        BufferedImage bi = null;
        FileWriter fileWriter = null;
        try {
            bi = ImageIO.read(srcFile);
            if (bi == null) {
                return;
            }

            int step = simpleSize; //大小 数值越大图像越小
            fileWriter = new FileWriter(dstFile);
            StringBuilder strBuilder = new StringBuilder();
            for (int j = 0; j < bi.getHeight(); ) { //读取一行
                for (int i = 0; i < bi.getWidth(); ) { //读取一列
                    int color = bi.getRGB(i, j); //某一像素
                    char c = colorToChar(color);
                    strBuilder.append(c);
                    strBuilder.append(c);//默认字体是半角，输出的宽比较小，所以输出两遍
                    i += step;
                }
                strBuilder.append("\n");
                j += step;
            }
            String ascii = strBuilder.toString();
            System.out.print(ascii);
            fileWriter.write(ascii);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据彩色点灰度获取对应字符
     * @param color
     * @return
     */
    public static char colorToChar(int color) {
        Color tcolor = new Color(color);
        if (tcolor.getAlpha() == 0) {
            return ' ';
        }
        /** 彩色转灰度，心理学公式，参数可调
         * 彩色转灰度算法参见 http://www.cnblogs.com/diewcs/archive/2010/10/03/1841744.html
         */
        //int gray = (2126 * tcolor.getRed() + 7152 * tcolor.getGreen() + 722 * tcolor.getBlue()) / 10000;
        int gray = (299 * tcolor.getRed() + 587 * tcolor.getGreen() + 114 * tcolor.getBlue() + 500) / 1000;
        int inext = gray * charTable.length / 256;
        return charTable[inext];
    }
}