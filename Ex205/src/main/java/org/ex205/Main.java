package org.ex205;

import org.ex205.exp.ArithmeticExpression;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String expression= scanner.nextLine();
        ArithmeticExpression arithmeticExpression=new ArithmeticExpression(expression);

        System.out.println(arithmeticExpression.getResult());

    }
}
