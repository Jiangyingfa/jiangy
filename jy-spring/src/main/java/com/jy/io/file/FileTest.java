package com.jy.io.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * java.io.File类
 * 1、凡是与输入输出相关的类、接口等，都定义在java.io包下
 * 2、是一个类，可以由构造器创建其对象，此对象对应一个文件或文件目录。
 * 3、File中的方法仅涉及到如何创建、删除、重命名等，不涉及到文件本身的内容。涉及到文件内容的操作，需要用流来解决。
 *
 * File类与IO流的关系：File类的对象常作为IO流具体类的构造器的形参。
 *
 */
public class FileTest {

    /**
     * 路径：绝对路径：包括盘幅在内的完整文件路径
     *      相对路径：在当前路径下的文件路径
     */
    @Test
    public void test(){
        File file = new File("D:/helloWorld.txt");//文件
        File file1 = new File("D:/io");//文件目录

        //一、访问文件名相关
        System.out.println(file.getName());//文件名称
        System.out.println(file.getPath());//文件路径
        System.out.println(file.getAbsoluteFile());//文件绝对文件名（包含路径）
        System.out.println(file.getAbsolutePath());//文件绝对路径
        System.out.println(file.getParent());//文件的上一层文件目录

        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getParent());

        /*
         * renameTo(File file1)重命名：
         * 1、文件重命名为文件，文件夹重命名为文件夹，不能交叉使用。
         * 2、将file重命名为file2，要求：file一定存在，file2一定不存在。
         * 3、文件目录重命名时不能跨盘幅。
         */
        File file2 = new File("D:/helloworld1.txt");
        boolean result = file.renameTo(file2);//将file重命名为file2，要求：file一定存在，file2一定不存在

    }

    @Test
    public void test2(){

        //二、文件检测、常规信息获取
        File file1 = new File("D:/file1.txt");
        File file2 = new File("D:/file2");

        System.out.println(file1.exists());//文件是否存在
        System.out.println(file1.canRead());//是否可读、可写canWrite
        System.out.println(file1.isFile());//是否存在
        System.out.println(file1.isDirectory());//是否文件目录
        System.out.println(new Date(file1.lastModified()));//上次修改时间
        System.out.println(file1.length());//文件长度

        System.out.println(file2.exists());//文件是否存在
        System.out.println(file2.canRead());//是否可读、可写canWrite
        System.out.println(file2.isFile());//是否存在
        System.out.println(file2.isDirectory());//是否文件目录
        System.out.println(new Date(file2.lastModified()));//上次修改时间
        System.out.println(file2.length());//文件长度

    }

    @Test
    public void test3(){

        //三、创建文件、文件夹，删除文件、文件夹
        File file1 = new File("D:/file1.txt");
        File file2 = new File("D:/file2");

        try {
            if(!file1.exists()){
                boolean b = file1.createNewFile();//新建文件
                System.out.println(b);
            }
            file1.delete();//删除文件

            if(!file2.exists()){
                file2.mkdir();//创建文件夹
            }
            file2.delete();//删除文件夹

            //mkdir()：上层文件目录必须存在才能创建目录成功；mkdirs()：上层文件目录不存在时，会创建上层文件目录以及当前文件目录
            File file3 = new File("D:/io/file1");
            if(!file3.exists()){
                file3.mkdirs();
            }

            //list() 、listFiles()
            String[] files = file3.list();//file3下的所有文件名
            File[] listFile = file3.listFiles();//file3下所有的文件


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
