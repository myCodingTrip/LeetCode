package contest.wc389.p3;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] letterCountArr = new int[26];
        char[] toCharArray = word.toCharArray();
        for (char c : toCharArray) {
            letterCountArr[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (letterCountArr[i] > 0) {
                int max = letterCountArr[i] + k;
                int min = letterCountArr[i];
                int tempRes = 0;
                for (int j = 0; j < 26; j++) {
                    if (j != i && letterCountArr[j] > 0) {
                        if (letterCountArr[j] > max) {
                            tempRes += letterCountArr[j] - max;
                        } else if (letterCountArr[j] < min) {
                            tempRes += letterCountArr[j];
                        }
                    }
                }
                res = Math.min(res, tempRes);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeletions("dabdcbdcdcd", 2));
        System.out.println(new Solution().minimumDeletions("aabcaba", 0));
        System.out.println(new Solution().minimumDeletions("zvzz", 1));
    }
}
