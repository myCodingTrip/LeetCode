package contest.wc364.p1;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int length = s.length();
        int zeroNum = 0;
        //int oneNum = 1;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') {
                zeroNum++;
            }
        }
        char[] res = new char[length];
        res[length - 1] = '1';
        for (int i = length - 2; i >= 0; i--) {
            if (zeroNum > 0) {
                res[i] = '0';
                zeroNum--;
            } else {
                res[i] = '1';
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumOddBinaryNumber("010"));
    }
}
