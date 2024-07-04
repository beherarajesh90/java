package com.java.leetcode.stack;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for (String dir: dirs){
            if (dir.equals(".") || dir.isEmpty()){
                continue;
            } else if (dir.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.add(dir);
            }
        }
        return "/"+String.join("/",stack);
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }
}
