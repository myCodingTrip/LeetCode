package contest.wc373.p2;

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
        int res = 0;
        for (int i = 0; i < length; i++) {
            int vowelNum = 0;
            int consonantNum = 0;
            if (voowelList.contains(s.charAt(i))) {
                vowelNum++;
            } else {
                consonantNum++;
            }
            for (int j = i + 1; j < length; j++) {
                if (voowelList.contains(s.charAt(j))) {
                    vowelNum++;
                } else {
                    consonantNum++;
                }
                if (vowelNum == consonantNum && (vowelNum * consonantNum) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulSubstrings("baeyh", 2));
    }
}
