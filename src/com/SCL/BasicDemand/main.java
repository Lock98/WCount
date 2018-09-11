package com.SCL.BasicDemand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main{
public static void main(String[] args) {

        while (true){

        // 输出面板
        System.out.println("\n---------------------3116005153 WC程序---------------------");
        System.out.println("************                                    ***********");
        System.out.println("  **       -all    返回字符数、单词数、行数         ");
        System.out.println("  **        -a [文件路径]  统计代码行/空行/注释行      ");
        System.out.println("-----------------------------------------------------------");

        // 获取输入指令

        System.out.print("[Please...] 请输入命令：");
       Scanner input=new Scanner(System.in);
       // String c=input.next();
        String m=input.nextLine();
        String arr[]=m.split("\\s");

        // 根据获取指令来执行函数
        try{
        switch(arr[0]){
        case"-all":Counter.counter(); break;   //返回字符数、单词数、行数
        case"-a":  Code.code(arr[0])     ;break;    //统计代码行 / 空行 / 注释行
        default:System.out.println("\n********  不存在该功能指令!");break;
        }
         } catch (FileNotFoundException e) {
        System.out.println("\n********  发生错误：输入路径文件找不到！！！  **********");
    } catch (IOException e){
        System.out.println("\n********  发生错误：文件读入发生异常！！！  **********");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        }
}