package org.ex205.exp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ArithmeticExpression {
    private String expr;

    public ArithmeticExpression(String expr) {
        this.expr = expr;
    }

    public Integer getResult(){
        String expression = expr.replaceAll(" ", "");

        Stack<Character> operatorStack = new Stack<>();

        Stack<Integer> operandStack = new Stack<>();

        Map<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('(', 0);
        priorityMap.put('+', 1);
        priorityMap.put('-', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    num = num * 10 + (expression.charAt(i + 1) - '0');
                    i++;
                }

                operandStack.push(num);
            } else if (c == '(') {

                operatorStack.push(c);
            } else if (c == ')') {

                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    calculateOnce(operatorStack, operandStack);
                }

                operatorStack.pop();
            } else {

                while (!operatorStack.isEmpty() && priorityMap.get(c) <= priorityMap.get(operatorStack.peek())) {
                    calculateOnce(operatorStack, operandStack);
                }

                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            calculateOnce(operatorStack, operandStack);
        }

        return operandStack.pop();
    }
    private static void calculateOnce(Stack<Character> operatorStack, Stack<Integer> operandStack) {
        char operator = operatorStack.pop();

        int num2 = operandStack.pop();
        int num1 = operandStack.pop();

        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        operandStack.push(result);
    }

}
