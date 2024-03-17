package contest.wc230903.p2;

class Solution {
    public int minimumOperations(String num) {
        int a1 = 0, a2 = 0, a3 = 5;
        int res1 = f(num, a1, a2, a3);
        int res2 = f(num, 5, 2, 7);
        int res = Math.min(res1, res2);
        if (num.contains("0")) {
            res = Math.min(res, num.length() - 1);
        }
        return res;
    }

    private int f(String num, int a1, int a2, int a3) {
        int res1 = 0;
        boolean second = false;
        boolean success = false;
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int i1 = c - '0';
            if (!second) {
                if (i1 != a1) {
                    res1++;
                } else {
                    second = true;
                }
            } else {
                if (i1 != a2 && i1 != a3) {
                    res1++;
                } else {
                    success = true;
                    break;
                }
            }
        }
        if (!success) {
            res1 = num.length();
        }
        return res1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations("5"));
    }
}
