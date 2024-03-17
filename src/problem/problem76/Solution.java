package problem.problem76;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int start = 0, minLength = s.length() + 1;
        int l = 0, r = t.length() - 1;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = l; i <= r; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        while (true) {
            // 保证从需要的地方开始
            while (l <= r - t.length() && !tMap.containsKey(s.charAt(l))) {
                char lChar = s.charAt(l);
                sMap.put(lChar, sMap.getOrDefault(lChar, 0) - 1);
                if (sMap.get(lChar) == 0) sMap.remove(lChar);
                l++;
            }
            //找到一个子串
            if (contain(sMap, tMap)) {
                int length = r - l + 1;
                if (length < minLength) {
                    start = l;
                    minLength = length;
                }
                char lChar = s.charAt(l);
                sMap.put(lChar, sMap.getOrDefault(lChar, 0) - 1);
                if (sMap.get(lChar) == 0) sMap.remove(lChar);
                l++;
            } else {
                r++;
                if (r == s.length()) break;
                char rChar = s.charAt(r);
                sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);
            }
        }

        if (minLength == s.length() + 1) {
            return "";
        } else {
            return s.substring(start, start + minLength);
        }
    }

    private boolean contain(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Character c : tMap.keySet()) {
            if (sMap.getOrDefault(c, 0) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
    }
}
