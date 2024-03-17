package contest.wc378.p3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumLength(String s) {
        int length = s.length();
        int result = -1;
        int i = 0, j = 0;
        Set<String> set = new HashSet<>();
        while (i < length) {
            String substring = s.substring(i, j + 1);
            if (!set.contains(substring) && substring.length() > result) {
                int count = countSubstrings(s, substring);
                set.add(substring);
                if (count >= 3) {
                    result = Math.max(result, j - i + 1);
                } else {
                    while (i + 1 < length && s.charAt(i + 1) == s.charAt(i)) {
                        i++;
                    }
                    if (j < i) j = i;
                }
            }
            if (j + 1 < length && s.charAt(j + 1) == s.charAt(j)) {
                j++;
            } else {
                i++;
                if (j < i) j = i;
            }
        }
        return result;
    }


    public static int countSubstrings(String mainString, String subString) {
        int count = 0;
        int index = mainString.indexOf(subString);
        while (index != -1) {
            count++;
            index = mainString.indexOf(subString, index + 1);
        }
        return count;
    }
}
