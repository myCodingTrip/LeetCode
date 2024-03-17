package contest.wc373.p4;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int beautifulSubstrings(String s, int k) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        List<Character> voowelList = new ArrayList<>();
        for (char vowel : vowels) {
            voowelList.add(vowel);
        }
        int length = s.length();
        int vowelNum = 0;
        int consonantNum = 0;
        int start = 0, end = 0;
        while (end < length) {
            if (voowelList.contains(s.charAt(end))) {
                vowelNum++;
            } else {
                consonantNum++;
            }

            end++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulSubstrings(null, 1));
    }
}
