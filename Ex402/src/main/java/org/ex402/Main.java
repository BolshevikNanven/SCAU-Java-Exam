package org.ex402;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Integer num,min,max,rightNum=0;

        System.out.println("输入加法练习的题目数量：");
        num= scanner.nextInt();
        System.out.println("输入加法练习的加数范围的最小值：");
        min= scanner.nextInt();
        System.out.println("输入加法练习的加数范围的最大值：");
        max= scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            MathExam mathExam=new MathExam(max,min);
            System.out.printf("题目%d：%d + %d = ?,请输入你的答案：",i,mathExam.getNumber1(),mathExam.getNumber2());
            if(scanner.nextInt()==mathExam.getAnswer()){
                System.out.println("正确");
                rightNum++;
            }else{
                System.out.println("错误");
            }
        }

        System.out.printf("一共答对了%d个题目!",rightNum);

    }
}
