package problem.problem139;

import java.util.Arrays;
import java.util.List;


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        //[0,i)的字符串是否能够被空格拆分为一个或多个在字典中出现的单词
        boolean[] dp = new boolean[length + 1];
        //默认""可以
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (!dp[j] && dp[i]) {
                    String str = s.substring(i, j);
                    if (wordDict.contains(str)) {
                        dp[j] = true;
                        if (dp[length]) return true;
//                    System.out.println(Arrays.toString(dp));
                    }
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }
}
