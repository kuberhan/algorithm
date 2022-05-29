package com.kuber.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class inputStreamTest {

    public static void main(String[] args) throws IOException {
        final String path = "D:/HadoopTestFile/wordcounttest/data/hello.txt";
        //1、得到数据文件
        File file = new File(path);
        //2、建立数据通道
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buf = new byte[1024];
        int length = 0;
        //循环读取文件内容，输入流中将最多buf.length个字节的数据读入一个buf数组中,返回类型是读取到的字节数。
        //当文件读取到结尾时返回 -1,循环结束。
        while((length = fileInputStream.read(buf)) != -1){
            System.out.print(new String(buf,0,length));
        }
        //最后记得，关闭流
        fileInputStream.close();
    }

}
