package com.SCL.BasicDemand;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Counter {
    public static void counter( ) throws Exception {
        // 统计一个文件的字符数，单词数，行数
       Scanner input = new Scanner(System.in);

        System.out.println("请输入路径");
        String path = input.next();

        File file = new File(path);
        FileReader reader = new FileReader(file);
        int countChar = 0;
        int countword = 0;
        int countline = 0;
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
        //InputStreamReader将字符流向字节流转换。

        BufferedReader br = new BufferedReader(isr);//使用缓冲区，可以使用缓冲区的read(),readLine()方法；
  //readLine每次读取一行，read()读取整个文件，是生成文件内容最直接的方式，

        while(br.read()!=-1)//read()=-1代表数据读取完毕
        {
            String s = br.readLine();
            countChar += s.length();//字符个数就是字符长度
            countword += s.split(" ").length;//split() 方法用于把一个字符串分割成字符串数组,字符串数组的长度，就是单词个数
            countline++;//因为是按行读取，所以每次增加一即可计算出行的数目
        }
        isr.close();//关闭文件

        System.out.println("char count "+countChar);
        System.out.println("word count "+countword );
        System.out.println("line count "+countline);
    }
}