package com.llstq;

import java.util.Stack;

public class Calculator {

    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> integerStack = new Stack<>();
        int index = 0;
        index = generateNumber(s, integerStack, index);
        while(index < s.length()) {
            index = performOperation(s, integerStack, index);
        }

        int finalValue = 0;
        while (integerStack.size() != 0) {
            finalValue = finalValue + integerStack.pop();
        }

        return finalValue;
    }

    private int generateNumber(String s, Stack<Integer> integerStack, int index) {
        int num =0;
        while(index < s.length() && Character.isDigit(s.charAt(index))) {
            num = 10*num + Character.getNumericValue(s.charAt(index));
            index = index + 1;
        }
        integerStack.push(num);
        return index;
    }

    private int performOperation(String s, Stack<Integer> integerStack, Integer index) {
        Character operation = null;
        while(!Character.isDigit(s.charAt(index))) {
            if(s.charAt(index) != ' ') {
              operation = s.charAt(index);
            }
            index++;
        }
        index = generateNumber(s, integerStack, index);
        operate(integerStack, operation);
        return index;
    }

    private void operate(Stack<Integer> integerStack, Character operation) {
        switch (operation) {
            case '*':
                integerStack.push(integerStack.pop() * integerStack.pop());
                break;
            case '/':
                Integer last = integerStack.pop();
                Integer nextToLast = integerStack.pop();
                integerStack.push(nextToLast / last);
                break;
            case '-':
                integerStack.push(-1 * integerStack.pop());
                break;
            default:
                break;
        }
    }
}
