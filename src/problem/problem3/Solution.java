package problem.problem3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        int maxLength = 1;
//        map.put(s.charAt(0), 0);
        int i = 0, j = -1;//【i，j】
        while (j < s.length() - 1) {
            // 需要一个j+1的“试探”
            char c = s.charAt(j + 1);
            //发现重复字符，移动左指针
            if (indexMap.containsKey(c)) {
                indexMap.remove(s.charAt(i));
                i++;
            } else {
                //未发现重复字符，延长子数组，更新长度
                indexMap.put(c, j);
                j++;
                int length = j - i + 1;
                if (length > maxLength) maxLength = length;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(sol.lengthOfLongestSubstring("bbbbbbb"));//1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(sol.lengthOfLongestSubstring("au"));//2
        System.out.println(sol.lengthOfLongestSubstring("tmmzuxt"));//5
        System.out.println(sol.lengthOfLongestSubstring("dvdf"));//3
    }
}
