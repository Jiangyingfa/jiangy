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
 * 文件的注意：
 * 1、mkdir()：上层文件目录必须存在才能创建目录成功；
 * 2、mkdirs()：上层文件目录不存在时，会创建上层文件目录以及当前文件目录
 * 3、遍历文件的方法list() 、listFiles()需要注意使用场景
 * 4、文件夹使用delete()时，当文件夹下没有非空文件才会删除成功，否则会失败
 */
public class FileTest {

    /**
     * 路径：绝对路径：包括盘幅在内的完整文件路径
     *      相对路径：在当前路径下的文件路径
     */
    //一、访问文件名相关：获取文件名的一些信息
    @Test
    public void test1(){
        File file = new File("D:/helloWorld.txt");//文件
        File file1 = new File("D:/file2");//文件目录

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
        file.renameTo(file2);

    }

    //二、文件检测、常规信息获取
    @Test
    public void test2(){
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

    //三、创建文件、文件夹，删除文件、文件夹
    @Test
    public void test3(){
        File file1 = new File("D:/file1.txt");
        File file2 = new File("D:/file2/io");
        File file3 = new File("D:/file3/io");
        File file4 = new File("D:/helloworld1.txt");
        File file5 = new File("D:/file4/io");
        try {
            //1、创建一个空文件并删除
            if(!file1.exists()){
                boolean b = file1.createNewFile();//新建文件
                System.out.println("file1是否创建成功："+b);
            }
            boolean b1 = file1.delete();//删除文件
            System.out.println("file1是否删除：" + b1);

            //2、是否能删除一个非空文件：是
            if(!file4.exists()){
                boolean a = file4.createNewFile();
                System.out.println("file4是否创建成功：" + a);
            }
            boolean a1 = file4.delete();
            System.out.println("file4是否删除：" + a1);

            //3.1、是否能删除一个非空文件夹：文件夹下还有子文件夹，且子文件夹中有非空文件：否
            if(!file2.exists()){
                boolean f3 = file2.mkdirs();
                System.out.println("file2是否创建成功：" + f3);
            }
            boolean b3 = file2.delete();
            System.out.println("file2是否删除：" + b3);

            //3.2、遍历文件夹
            String[] files = file2.list();//file2下的所有文件名
            File[] listFile = file2.listFiles();//file2下所有的文件
            for(int i=0; i<files.length; i++){
                System.out.println("file2下，第" + (i+1) +"个文件：" + files[i]);
            }

            //listFile[i]展示的是文件所在的绝对地址
            for (int i=0; i<listFile.length; i++){
                System.out.println("file2下，第" + (i+1) +"个文件,文件内存地址：" + listFile[i]);
            }

            //4.1、是否能删除文件夹：文件夹下还有子文件夹，且子文件夹中有空文件：是
            if(!file3.exists()){
                boolean f2 = file3.mkdir();//创建文件夹
                System.out.println("file3使用mkdir是否创建成功：" + f2);
                boolean f1 = file3.mkdirs();
                System.out.println("file3使用mkdirs是否创建成功：" +f1);
            }
            boolean b2 = file3.delete();//删除文件夹
            System.out.println("file3是否删除：" + b2);

            //4.2、是否能删除文件夹：文件夹下还有子文件夹，但子文件夹中没有文件：是
            if(!file5.exists()){
                boolean f2 = file5.mkdir();//创建文件夹
                System.out.println("file5使用mkdir是否创建成功：" + f2);
                boolean f1 = file5.mkdirs();
                System.out.println("file5使用mkdirs是否创建成功：" +f1);
            }
            boolean b4 = file5.delete();//删除文件夹
            System.out.println("file5是否删除：" + b4);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
