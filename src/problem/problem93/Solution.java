package problem.problem93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //5.08%—>15.20
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        if (length < 4 || length > 12) return res;
        for (int i = 0; i < 3; i++) {
            String s1 = s.substring(0, i + 1);
            //回溯
            if (!isRight(s1)) continue;
            for (int j = i + 1; j < Math.min(i + 4, length - 2); j++) {
                String s2 = s.substring(i + 1, j + 1);
                //回溯
                if (!isRight(s2)) continue;
                for (int k = j + 1; k < Math.min(j + 4, length - 1); k++) {
                    if (k < length - 4) continue;

                    String s3 = s.substring(j + 1, k + 1);
                    //回溯
                    if (!isRight(s3)) continue;

                    String s4 = s.substring(k + 1, length);
                    //回溯
                    if (!isRight(s4)) continue;

                    String ip = s1 + "." + s2 + "." + s3 + "." + s4;
                    //没有因为多余的0产生长度变化
                    res.add(ip);
                }
            }
        }
        return res;
    }

    private boolean isRight(String s1) {
        Integer i1 = Integer.valueOf(s1);
        //回溯
        if ((s1.length() > 1 && s1.charAt(0) == '0') || i1 > 255) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }
}
