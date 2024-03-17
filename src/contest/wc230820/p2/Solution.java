package contest.wc230820.p2;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumSum(int n, int k) {
        int[] res = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; ; j++) {
                if (j > k) {
                    if (!set.contains(j)) {
                        res[i] = j;
                        set.add(j);
                        break;
                    }
                } else if (!set.contains(j) && !set.contains(k - j)) {
                    res[i] = j;
                    set.add(j);
                    set.add(k - j);
                    break;
                }
            }
        }
        int sum = 0;
        for (int i : res) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSum(6, 5));
    }
}
