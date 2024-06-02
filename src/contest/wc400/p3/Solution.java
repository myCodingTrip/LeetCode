package contest.wc400.p3;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String clearStars(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer>[] stacks = new Stack[26];
        Arrays.setAll(stacks, i -> new Stack<>());
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '*') {
                for (Stack<Integer> stack : stacks) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        break;
                    }
                }
            } else {
                stacks[chars[i] - 'a'].push(i);
            }
        }
        char[] chars1 = new char[s.length()];
        for (int i = 0; i < 26; i++) {
            Stack<Integer> stack = stacks[i];
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                chars1[pop] = (char) ('a' + i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars1) {
            if (c != '\0') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().clearStars("aaba*"));
    }
}
