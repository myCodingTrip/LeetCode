package problem.problem131;

import java.util.ArrayList;
import java.util.List;

//todo 43.66
class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null) return res;
        dfs(0, s, new ArrayList<>());
        return res;
    }

    private void dfs(int start, String s, List<String> temp) {
        int len = s.length();
        if (start == len) {
            return;
        }
        for (int i = start + 1; i <= len; i++) {
            String substring = s.substring(start, i);
            if (isPlalindrome(substring)) {
                if (i == len) {
                    temp.add(substring);
                    res.add(new ArrayList<>(temp));
                    temp.remove(temp.size() - 1);
                } else {
                    temp.add(substring);
                    dfs(i, s, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private boolean isPlalindrome(String s) {
        if ("".equals(s)) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
