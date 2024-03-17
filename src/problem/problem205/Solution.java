package problem.problem205;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> kvMap = new HashMap<>();
        Map<Character, Character> vkMap = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!kvMap.containsKey(c1)) {
                if (vkMap.containsKey(c2) && !(c1 == vkMap.get(c2))) return false;
                kvMap.put(c1, c2);
                vkMap.put(c2, c1);
            } else {
                if (c2 != kvMap.get(c1) || c1 != vkMap.get(c2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
