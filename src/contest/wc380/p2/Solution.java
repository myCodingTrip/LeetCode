package contest.wc380.p2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> tempA = new ArrayList<>();
        List<Integer> tempB = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i <= s.length() - a.length() && compare(i, s, a)) {
                tempA.add(i);
            }
            if (i <= s.length() - b.length() && compare(i, s, b)) {
                tempB.add(i);
            }
        }
        for (Integer i : tempA) {
            for (Integer j : tempB) {
                if (Math.abs(i - j) <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }

    private boolean compare(int i, String s, String a) {
        for (int j = 0; j < a.length(); j++) {
            if (s.charAt(i + j) != a.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulIndices("isawsquirrelnearmysquirrelhouseohmy",
                "my",
                "squirrel",
                15));
    }
}
