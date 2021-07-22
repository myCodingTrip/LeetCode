package problem20;

import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("{"));
    }

    /**
     * 括号匹配
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Character top;
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty()) return false;
                    top = stack.pop();
                    if (top != '(') return false;
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ']':
                    if (stack.empty()) return false;
                    top = stack.pop();
                    if (top != '[') return false;
                    break;
                case '{':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.empty()) return false;
                    top = stack.pop();
                    if (top != '{') return false;
                    break;
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
}