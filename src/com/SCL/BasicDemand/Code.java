package com.SCL.BasicDemand;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Code{
    static   int annotationLine = 0;
    static int blankLine;
    static int codeLine;
    static int  totalLine;


    public   static  void  code(String s)throws FileNotFoundException {
        System.out.println("请输入要统计代码量的java文件：");
        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();
        File file = new File(filePath);
        Start(file);
        System.out.println("－－－－－－－－－－统计结果－－－－－－－－－");

        System.out.println(file + "文件/目录总行数：" + totalLine);
        System.out.println("代码行数：" + codeLine);
        System.out.println("注释行数：" + annotationLine);
        System.out.println("空白行数：" + blankLine);


    }	private static void  Start(File file) throws FileNotFoundException {
        if (file == null || !file.exists())
            throw new FileNotFoundException(file + "，文件不存在！");



        if (file.isDirectory()) {
            File[] files = file.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".java") || pathname.isDirectory();
                }
            });

            for (File target : files) {
             Start(target);
            }
        } else {
            BufferedReader bufr = null;
            try {
                // 将指定路径的文件与字符流绑定
                bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException(file + "，文件不存在！" + e);
            }

            // 定义匹配每一行的正则匹配器
            Pattern annotationLinePattern = Pattern.compile("((//)|(/\\*+)|((^\\s)*\\*)|((^\\s)*\\*+/))+",
                    Pattern.MULTILINE + Pattern.DOTALL);	// 注释匹配器(匹配单行、多行、文档注释)

            Pattern blankLinePattern = Pattern.compile("^\\s*$");	// 空白行匹配器（匹配回车、tab键、空格）

            String line = null;
            try {
                while((line = bufr.readLine()) != null) {
                    if (annotationLinePattern.matcher(line).find()) {
                        annotationLine ++;
                    }

                    if (blankLinePattern.matcher(line).find()) {
                        blankLine ++;
                    }
                     else {
                        codeLine++;// 除空白行和注释行外，其余皆为代码行
                    }

                    totalLine ++;
                }
            } catch (IOException e) {
                throw new RuntimeException("读取文件失败！" + e);
            } finally {
                try {
                    bufr.close();	// 关闭文件输入流并释放系统资源
                } catch (IOException e) {
                    throw new RuntimeException("关闭文件输入流失败！");
                }
            }
        }
    }
}
