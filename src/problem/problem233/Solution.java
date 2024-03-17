package problem.problem233;

class Solution {
    public int countDigitOneTimeout(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (c == '1') {
                    res++;
                }
            }
        }
        return res;
    }

    public int countDigitOne(int n) {
        int res = 0;
        for (long k = 10; k <= n * 10L; k *= 10) {
            res += n / k * k / 10;
            long mod = n % k;
            if (mod >= k / 5) {
                res += k / 10;
            } else if (mod >= k / 10) {
                res += mod - k / 10 + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 100; i++) {
            int i1 = solution.countDigitOne(i);
            int i2 = solution.countDigitOneTimeout(i);
            if (i1 != i2) {
                System.out.println(i);
                System.out.println(i1 + " " + i2 + "\n");
            }
        }
        System.out.println(solution.countDigitOne(767944060));
        ;
    }
}
