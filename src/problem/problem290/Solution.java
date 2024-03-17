package problem.problem290;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> kvMap = new HashMap<>();
        Map<String, Character> vkMap = new HashMap<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (!kvMap.containsKey(c)) {
                if (vkMap.containsKey(word) && !(c == vkMap.get(word))) return false;
                kvMap.put(c, word);
                vkMap.put(word, c);
            } else {
                if (!word.equals(kvMap.get(c)) || !(c == vkMap.get(word))) {
                    return false;
                }
            }
        }
        return true;
    }
}
