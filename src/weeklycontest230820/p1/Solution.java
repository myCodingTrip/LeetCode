package weeklycontest230820.p1;

import java.util.List;

class Solution {
    public boolean isAcronym(List<String> words, String s) {
        int size = words.size();
        if (size != s.length()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            String s1 = words.get(i);
            if ((s1.charAt(0)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
