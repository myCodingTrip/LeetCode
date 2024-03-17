package problem.problem150;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        List<String> signs = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (signs.contains(token)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                Integer num = 0;
                switch (token) {
                    case "+":
                        num = num2 + num1;
                        break;
                    case "-":
                        num = num2 - num1;
                        break;
                    case "*":
                        num = num2 * num1;
                        break;
                    case "/":
                        num = num2 / num1;
                        break;
                }
                stack.add(num);
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
