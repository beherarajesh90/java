package com.java.dsa.stacks.problems;

import java.util.Stack;

public class EvaluatePrefix {
    static boolean isdigit(char ch)
    {
        if(ch >= 48 && ch <= 57)
        {
            return true;
        }
        return false;
    }

    static double evaluatePrefix(String exprsn)
    {
        Stack<Double> stack = new Stack<Double>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {

            // if jth character is the delimiter ( which is
            // space in this case) then skip it
            if (exprsn.charAt(j) == ' ')
                continue;

            // Push operand to Stack
            // To convert exprsn[j] to digit subtract
            // '0' from exprsn[j].
            if (isdigit(exprsn.charAt(j))) {

                // there may be more than
                // one digits in a number
                double num = 0, i = j;
                while (j < exprsn.length() && isdigit(exprsn.charAt(j)))
                    j--;
                j++;

                // from [j, i] exprsn contains a number
                for (int k = j; k <= i; k++)
                {
                    num = num * 10 + (double)(exprsn.charAt(k) - '0');
                }

                stack.push(num);
            }
            else {

                // Operator encountered
                // Pop two elements from Stack
                double o1 = (double)stack.peek();
                stack.pop();
                double o2 = (double)stack.peek();
                stack.pop();

                // Use switch case to operate on o1
                // and o2 and perform o1 O o2.
                switch (exprsn.charAt(j)) {
                    case '+':
                        stack.push(o1 + o2);
                        break;
                    case '-':
                        stack.push(o1 - o2);
                        break;
                    case '*':
                        stack.push(o1 * o2);
                        break;
                    case '/':
                        stack.push(o1 / o2);
                        break;
                }
            }
        }

        return stack.peek();
    }

    // Driver code
    public static void main(String[] args) {
        String exprsn = "+ 9 * 12 6";
        System.out.print((int)evaluatePrefix(exprsn));
    }
}
