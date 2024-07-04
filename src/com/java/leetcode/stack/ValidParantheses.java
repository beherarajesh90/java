package com.java.leetcode.stack;

import java.util.Stack;

public class ValidParantheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean res = true;
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else if(stack.isEmpty() || (ch == ')' && stack.peek()!='(') || (ch==']' && stack.peek()!='[') || (ch=='}' && stack.peek()!='{')){
                res = false;
                break;
            } else {
                stack.pop();
            }
        }

        return !res ? res : stack.empty();
    }

    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;  // Early return if length is odd

        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;  // Push to stack
            } else {
                if (top == -1) return false;  // Stack is empty
                char topChar = stack[top];
                if ((c == ')' && topChar == '(') ||
                        (c == ']' && topChar == '[') ||
                        (c == '}' && topChar == '{')) {
                    top--;  // Pop from stack
                } else {
                    return false;
                }
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        String str = "()[}{]";
        System.out.println(isValid(str));
    }
}
