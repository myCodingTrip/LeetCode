package contest.wc230903.p1;

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int count = s.length();
            int rem = count % 2;
            if (rem == 1) {
                continue;
            }
            int half = count / 2;
            int half1 = 0;
            int half2 = 0;
            for (int j = 0; j < half; j++) {
                half1 += s.charAt(j);
                half2 += s.charAt(count - j - 1);
            }
            if (half1 == half2) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSymmetricIntegers(1, 100));
    }
}
