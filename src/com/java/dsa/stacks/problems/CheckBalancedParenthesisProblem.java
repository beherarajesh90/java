package com.java.dsa.stacks.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CheckBalancedParenthesisProblem {

    public static boolean isBalanced(String str){
        Deque<Character> dq = new ArrayDeque();
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            //push the opening brackets into the stack and continue
            if(ch=='{'||ch=='['||ch=='('){
                dq.push(ch);
                continue;
            }
            //if stack is empty and closing brackets encountered string not balanced
            if(dq.isEmpty()){
                return false;
            }
            //if stack is not empty and closing bracket encountered check for the possible falsy cases
            //if top of stack and current characters are same just pop it from the stack
            char topElement = dq.peek();
            if(ch==']' && (topElement=='('||topElement=='{')){
                return false;
            }
            else if(ch==')' && (topElement=='['||topElement=='{')){
                return false;
            }
            else if(ch=='}' && (topElement=='('||topElement=='[')){
                return false;
            }else{
                dq.pop();
            }
        }
        //if stack is empty balanced
        return dq.isEmpty();
    }

    public static void main(String[] args) {
        String expr = "{(}}[]";

        // Function call
        if (isBalanced(expr))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}

//public class CheckBalancedParenthesisProblem {
//
//    public static void main(String []argh)
//    {
//        System.out.println("Enter the inputs");
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            System.out.println("Taking input");
//
//            checkPattern(sc.next());
//            Deque<String> stack = new ArrayDeque<>();
//            int flag=0;
//            String input=sc.next();
//            //Complete the code
//
//            for(int i=0;i<input.length();i++){
//                String c = String.valueOf(input.charAt(i));
//                if(c.equals("[") || c.equals("{") || c.equals("(")  ){
//                    stack.addFirst(c);
//                }
//                else{
//                    String top = stack.peek();
//                    if(top==null){
//                        System.out.println(false);
//                        flag=1;
//                        break;
//                    }
//                    else if(c.equals("}") && top.equals("{")){
//                        stack.removeFirst();
//                    }
//                    else if(c.equals("]") && top.equals("[")){
//                        stack.removeFirst();
//                    }
//                    else if(c.equals(")") && top.equals("(")){
//                        stack.removeFirst();
//                    }
//
//                }
//            }
//
//            if(stack.isEmpty() && flag==0){
//                System.out.println(true);
//            }
//            else if(!stack.isEmpty() && flag!=1){
//                System.out.println(false);
//            }
//        }
//
//    }
//
//    public static boolean checkPattern(String input) {
//        // Check if the input is null or empty
//        if (input == null || input.isEmpty()) {
//            return false;
//        }
//
//        // Store array and size for performance optimization
//        char[] charArray = input.toCharArray();
//        int charSize = charArray.length;
//        // Create a Dequeu to store the opening brackets
//        Deque<Character> deque = new ArrayDeque<>(charSize / 2);
//        // Loop through all characters
//        for (int i = 0; i < charSize; i++) {
//            // Store current character
//            char current = charArray[i];
//            // Store opening brackets
//            if (current == '(' || current == '{' || current == '[') {
//                deque.push(current);
//            } else {
//                // Check if the list starts with a closing bracket
//                if (deque.isEmpty()) {
//                    return false;
//                }
//
//                // Get previous character and remove it from the dequeu
//                char previous = deque.pop();
//                // Compare bracket types
//                if (current == ')' && previous != '(') {
//                    return false;
//                }
//
//                if (current == '}' && previous != '{') {
//                    return false;
//                }
//
//                if (current == ']' && previous != '[') {
//                    return false;
//                }
//            }
//        }
//
//        return deque.isEmpty();
//    }
//}
