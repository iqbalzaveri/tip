package com.llstq;

import java.util.Stack;

public class ValidParanthesis {
    Stack<Character> stack =new Stack<>();
    /*
    public boolean isValid(String s) {
        for (var i=0; i<s.length(); i++) {
            if(stack.size() > 0 && stack.peek() == oppositeChar(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }

            if(stack.size() == 0) {
                return true;
            }
        }
        return false;
    }
*/
    private char oppositeChar(char bracket) {

        char retBracket;
        switch (bracket) {
            case ')':
                retBracket = '(';
                break;
            case '}':
                retBracket = '{';
                break;
            case ']':
                retBracket = '[';
                break;
            default:
                retBracket = 'A';
        }
        return retBracket;
    }
}
