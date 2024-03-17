package problem.problem93;

import java.util.ArrayList;
import java.util.List;

//递归实现 2ms 96.43
class SolutionDFS {

    List<String> res;
    int length;
    StringBuilder sb = new StringBuilder();
    String temp;

    //5.08%—>15.20
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        temp = s;
        length = s.length();
        if (length < 4 || length > 12) return res;
        dfs(0, 0);
        return res;
    }

    private void dfs(int count, int start) {
        if (count > 3) {
//            System.out.println(sb.toString());
            if (start == length) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < Math.min(length, (count + 1) * 3); i++) {
            String substring = temp.substring(start, i + 1);
            if (isRight(substring)) {
                int length = sb.length();
                if (count == 3) {
                    sb.append(substring);
                } else {
                    sb.append(substring).append('.');
                }
                dfs(count + 1, i + 1);
                sb.delete(length, sb.length());
            }
        }
    }

    private boolean isRight(String s1) {
        Integer i1 = Integer.valueOf(s1);
        //回溯
        if ((s1.length() > 1 && s1.charAt(0) == '0') || i1 > 255) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionDFS().restoreIpAddresses("25525511135"));
    }
}
