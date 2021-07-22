package problem438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1 字符集问题
 * 2 多个解顺序
 */
class Solution {

    //140ms
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) return res;

        Map<Character, Integer> pMap = new HashMap<>();
        for (Character c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = p.length() - 1;    //[l,r]
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = l; i <= r; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean equal = false;
        while (r < s.length()) {
            if (equal || pMap.equals(sMap)) {
                res.add(l);
                equal = true;
            }
            char lChar = s.charAt(l);
            sMap.put(lChar, sMap.getOrDefault(lChar, 0) - 1);
            if (sMap.get(lChar) == 0) sMap.remove(lChar);
            l++;
            r++;
            if (r < s.length()) {
                char rChar = s.charAt(r);
                sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);
                if (rChar != lChar) {
                    equal = false;
                }
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
}