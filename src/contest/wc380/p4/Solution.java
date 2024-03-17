package contest.wc380.p4;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //KMP
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> kmpA = KMP(s, a);
        List<Integer> kmpB = KMP(s, b);
        for (Integer target : kmpA) {
            int l = 0, r = kmpB.size() - 1, mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                int diff = target - kmpB.get(mid);
                if (Math.abs(diff) <= k) {
                    res.add(target);
                    break;
                } else if (diff > 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return res;
    }

    private List<Integer> KMP(String s, String a) {
        int x = 0, y = 0;
        int[] next = getNextArr(a.toCharArray());
        List<Integer> res = new ArrayList<>();
        while (x < s.length() && y < a.length()) {
            if (s.charAt(x) == a.charAt(y)) {
                x++;
                y++;
                if (y == a.length()) {
                    res.add(x - y);
                    y = next[y];
                }
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return res;
    }

    private int[] getNextArr(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1, 0};
        }
        int[] next = new int[str2.length + 1];
        next[0] = -1;
        next[1] = 0;
        int i = 2, cn = 0;
        while (i <= str2.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulIndices("isawsquirrelnearmysquirrelhouseohmy",
                "my",
                "squirrel",
                15));
//        System.out.println(new Solution().beautifulIndices("abxd",
//                "a",
//                "a",
//                4));
    }
}
