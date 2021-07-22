package problem71;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir != null && dir.length() != 0 && !".".equals(dir)) {
                if ("..".equals(dir)) {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else {
                    stack.add(dir);
                }
            }
        }
        if (stack.empty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("//home/"));
        System.out.println(new Solution().simplifyPath("/../"));
    }
}