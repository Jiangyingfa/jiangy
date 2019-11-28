package com.jy.io.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 缓冲流：是一种处理流，相对节点流，能够加速流的处理速度
 * BufferedReader、BufferedWriter（flush()方法）
 * BufferedInputStream、BufferedOutputStream（flush()方法）
 */
public class TestBufferedInputStream {

    /**
     * BufferedInputStream、BufferedOutputStream
     * 实现复制: 非文本文件（虽然也可以实现文本文件的复制，但是耗时较长，浪费资源，一般不建议这样使用）
     */
    @Test
    public void test1(){
        long start = System.currentTimeMillis();

        File src = new File("D:/1.txt");
        File des = new File("E:/bufferedInputStream.txt");
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //先创建节点流，再用Buffered去包裹节点流（也证实了Buffered系列流是处理流）
            bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(des));
            byte[] b = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(b)) != -1){
                bufferedOutputStream.write(b,0,len);
                bufferedOutputStream.flush();//大都情况加上，刷新清空，写最后一次操作时，可能会存在存不满
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("BufferedInputStream复制文件耗时：" + (end - start));
    }

    /**
     * BufferedReader、BufferedWriter
     * 实现复制
     * 问题：不能读一个文件，写2个文件，只会有一个文件成功
     */
    @Test
    public void test2(){
        long start = System.currentTimeMillis();

        File src = new File("D:/1.txt");
        File des = new File("E:/bufferedReader.txt");
        File des1 = new File("E:/bufferedReader1.txt");
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        BufferedWriter bufferedWriter1 = null;

        try {
            //先创建节点流，再用Buffered去包裹节点流（也证实了Buffered系列流是处理流）
            bufferedReader = new BufferedReader(new FileReader(src));
            bufferedWriter = new BufferedWriter(new FileWriter(des));
            bufferedWriter1 = new BufferedWriter(new FileWriter(des1));

            //读取方式1：传统读取
            char[] b = new char[1024];
            int len;
            while ((len = bufferedReader.read(b)) != -1){
                bufferedWriter.write(b,0,len);
                bufferedWriter.flush();//大都情况加上，刷新清空，写最后一次操作时，可能会存不满
            }

            //读取方式2：readLine()
            String str = null;
            while ((str = bufferedReader.readLine()) != null){
                bufferedWriter1.write(str);
                bufferedWriter1.newLine();//实现自动换行
                bufferedWriter1.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter1 != null){
                try {
                    bufferedWriter1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("BufferedReader复制文件耗时：" + (end - start));
    }
}
