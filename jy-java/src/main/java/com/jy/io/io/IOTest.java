package com.jy.io.io;

/**
 * IO流：
 * 1、根据流向划分：（站在程序的角度考虑）① 输入input：从外部设备读取数据到内存中，文件→ 程序
 *                                ② 输出output：从内存读取数据到外部设备，程序 → 文件
 *   根据数据单位划分：① 字符流Reader、Writer（文本文件）； ② 字节流InputStream、OutputStream（视频文件、音频文件）；
 *   根据流的角色划分：① 节点流FileInputStream、FileOutputStream、FileReader、FileWriter：程序直接操作文件，流直接由程序到文件；
 *                 ② 处理流BufferedInputStream、BufferedOutputStream：在节点流外部又包了一层流，外部包的这层流叫处理流（缓冲流）；
 * 2、重点：文件流、缓冲流
 * 3、字符流的复制可以使用FileReader、FileWriter，其他类型文件的复制需要使用字节流实现
 * 4、实际开发过程中，大都使用BufferedInputStream、BufferedOutputStream、BufferedReader、BufferedWriter，
 *    因为其对应的方法都是非阻塞式的，而InputStream的都是阻塞式的（一直等待，不知道后边还会不会有数据）
 * 5、word文档进行复制的时候，使用字节流，因为文档里可能会存在图片，并且文字都是经过包装的，不是纯粹的文本文件。
 *   因此只有txt文本才适合使用Reader、Writer字符流进行操作。
 */
public class IOTest {
}
