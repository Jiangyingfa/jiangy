package com.jy.io.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 1、IO体系：
 * 抽象基类            节点流（文件流）
 * InputStream        FileInputStream
 * OutputStream       FileOutputStream
 * Reader             FileReader
 * Writer             FileReader
 */
public class TestFileInputStream {

    //从硬盘存在的一个文件中，读取其内容到程序中:使用FileInputStream
    //要求文件一定要存在，否则会抛异常FileNotFoundException，使用try-catch去处理异常更合适：因为如果在读取过程中发现有异常的话，则没办法关闭
    @Test
    public void test1(){
        File file = new File("D:/1.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);

            //read()：一个字节的读取，当执行到文件结尾时，返回-1时读取完成
            int b = fileInputStream.read();//此处隐式的把char转换成了int
            while(b != -1){
                System.out.println(((char)b));
                b = fileInputStream.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 一次读一个字节很浪费资源，开发效率不高，实际读取固定长度的字节
     * 使用read(byte[] b)
     */
    @Test
    public void test2(){
        File file = new File("D:/1.txt");
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(file);
            byte[] b = new byte[1024];
            int len = 0;//每次读入到byte中的长度
            while ((len = fs.read(b)) != -1){
                //for循环用到的判断，不能使用b.length去判断，因为可能存在实际读取字节小于1024，此情况下可能会造成复制的文件大小超过源文件
                String str = new String(b,0,len);//从0开始读取b数组，读取长度为len
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //如果这里不判断，会抛NullPointException
                if(fs != null){
                    fs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 输出流：OutputStream:
     * write()  write(byte[] b)
     */
    @Test
    public void test3(){
        //表明数据要写入的位置
        File file = new File("D:/2.txt");
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            //如果文件不存在，会自动创建
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("This sentence test for outputStream.".getBytes());

            //重新获取2.txt
            fileInputStream = new FileInputStream(file);
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.println("第一次获取写入的数据：" + str);
            }

            //接着2.txt继续写入数据，则会被覆盖
            fileOutputStream.write("\nThis sentence test for cover.".getBytes());

            //重新获取2.txt
            fileInputStream = new FileInputStream(file);
            while ((len = fileInputStream.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.println("第二次获取写入的数据:" + str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实现文件复制的方法: 可以复制文本、视频、音频
     * @Param src:源文件的路径（源文件一定存在）
     * @Param des:复制文件的存放路径，即源文件想要复制到哪里去（复制文件及其路径不一定存在）
     */
    public static void cpFile(String src, String des){
        File srcFile = new File(src);
        File desFile = new File(des);
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1){
                fos.write(b,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用字节流实现文件复制的耗时
     */
    @Test
    public void testCpFile(){
        long start = System.currentTimeMillis();
        String src = "D:/day15_01复习.wmv";
        String des = "D:/testCopyFile.wmv";
        cpFile(src,des);
        long end = System.currentTimeMillis();
        System.out.println("文件复制耗时：" + (end - start));
    }

}
