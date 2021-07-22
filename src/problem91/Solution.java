package problem91;

//todo 10.34%
class Solution {
    // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
    // dp[i] = dp[i - 1] * 1 if s[i] != '0'
    // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0') {
                dp[i] = dp[i - 1];
            }
            Integer num = Integer.valueOf(s.charAt(i - 1) + "" + c);

            if (num >= 10 && num <= 26) {
                if (i > 1) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i]++;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("10"));//1
        System.out.println(new Solution().numDecodings("100"));//0
        System.out.println(new Solution().numDecodings("110"));//1
        System.out.println(new Solution().numDecodings("27"));//1
        System.out.println(new Solution().numDecodings("230"));//0
        System.out.println(new Solution().numDecodings("1212"));//5
    }
}