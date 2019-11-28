package com.jy.io.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 字符流：FileReader、FileWriter
 * 字符流的复制可以使用FileReader、FileWriter，其他的需要使用字节流实现复制
 */
public class TestFileReader {
    /**
     * FileReader
     */
    @Test
    public void test1(){
        File file = new File("D:/1.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] b = new char[1024];
            int len = 0;
            while((len = fileReader.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 使用FileReader、FileWriter实现的是文本文件的复制，非文本文件要使用FileInputStream、FileOutputStream，即字节流
     * 复制: 输入流对应的文件一定要存在，输出流对应文件可以不存在
     */
    @Test
    public void test2(){
        File src = new File("D:/1.txt");
        File des = new File("D:/3.txt");
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader(src);
            writer = new FileWriter(des);

            char[] b = new char[1024];
            int len;
            while ((len = reader.read(b)) != -1){
                writer.write(b,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
