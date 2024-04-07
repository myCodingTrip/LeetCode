package contest.wc390.p1;

class Solution {
    public int maximumLengthSubstring(String s) {
        int res = 2;
        int length = s.length();
        char[] chars = s.toCharArray();
        int i = 0, j = 2;
        int[] lettersArr = new int[26];
        lettersArr[chars[0] - 'a']++;
        lettersArr[chars[1] - 'a']++;
        while (j < length) {
            j++;
            lettersArr[chars[j - 1] - 'a']++;
            if (lettersArr[chars[j - 1] - 'a'] < 3) {
                res = Math.max(res, j - i);
            } else {
                while (lettersArr[chars[j - 1] - 'a'] >= 3) {
                    lettersArr[chars[i] - 'a']--;
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLengthSubstring("aadaad"));
    }
}
