package problem.problem17;

import java.util.ArrayList;
import java.util.List;

//todo 比较慢
class Solution {

    private static String[] letterMap = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mon",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private List<String> res = new ArrayList<>();

    //复杂度3^n 最多处理到20
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        letterCombinations(digits, 0, "");
        return res;
    }

    private void letterCombinations(String digits, int index, String oneRes) {
        if (digits.length() == index) {
//            System.out.println(res);
            res.add(oneRes);
            return;
        }
        String s = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letterCombinations(digits, index + 1, oneRes + c);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations(null));
    }
}
