package problem202;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        while (true) {
            if (nums.contains(n)) return false;
            nums.add(n);
            n = next(n);
            if (n == 1) return true;
        }
    }

    private int next(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum += i * i;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(7));
    }
}