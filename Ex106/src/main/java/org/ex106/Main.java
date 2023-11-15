package org.ex106;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Integer input=scanner.nextInt();

        if(input<0){
            System.out.println("不正确的输入");
        }else {
            System.out.println(Integer.toHexString(input).toUpperCase());
        }

    }
}
