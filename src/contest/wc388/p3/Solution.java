package contest.wc388.p3;

import java.util.Arrays;

class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = "";
        }
        for (int k = 0; k < n; k++) {
            String str = arr[k];
            for (int len = 1; len <= str.length(); len++) {
                for (int i = 0; i <= str.length() - len; i++) {
                    String substring = str.substring(i, i + len);
                    if (notContains(arr, n, k, substring)) {
                        if ("".equals(res[k])) {
                            res[k] = substring;
                        } else if (res[k].length() == substring.length() && substring.compareTo(res[k]) < 0) {
                            res[k] = substring;
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean notContains(String[] arr, int n, int k, String substring) {
        for (int l = 0; l < n; l++) {
            if (l != k && arr[l].contains(substring)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shortestSubstrings(new String[]{"cab", "ad", "bad", "c"})));
    }
}
